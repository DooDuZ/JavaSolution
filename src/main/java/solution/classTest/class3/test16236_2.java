package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;


// ULRD -> 전체 탐색 후 진행으로 변경
public class test16236_2{
    static ArrayList<ArrayList<Cell>> cellBox = new ArrayList<>();
    static LinkedList<CellWrapper> queue = new LinkedList<>();

    static LinkedList<Cell> sameDistance = new LinkedList<>();

    static boolean[][] visited;
    static int row;
    static int col;
    static int N;
    static int count = 0;
    static int eatCount = 0;
    static int sharkSize = 2;

    static int currentTime = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        visited = new boolean[N][N];

        for(int i = 0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            ArrayList<Cell> list = new ArrayList<>();
            for(int j = 0 ; j<N ; j++){
                int fish = Integer.parseInt(st.nextToken());
                list.add(new Cell(fish,i,j));
                if(fish==9){
                    row = i;
                    col = j;
                }
            }
            cellBox.add(list);
        }

        for(int i = 0 ; i<N; i++){
            ArrayList<Cell> cells = cellBox.get(i);
            for(int j = 0; j<N; j++){
                if(i-1>=0){ cells.get(j).cellList.add( cellBox.get(i-1).get(j) );}
                if(j-1>=0){ cells.get(j).cellList.add( cellBox.get(i).get(j-1) );}
                if(j+1<N){ cells.get(j).cellList.add( cellBox.get(i).get(j+1) );}
                if(i+1<N){ cells.get(j).cellList.add( cellBox.get(i+1).get(j) );}
            }
        }

        queue.add(new CellWrapper(0, cellBox.get(row).get(col)));

        visited[row][col] = true;

        bfs();

        System.out.println(count);
    }

    static void bfs(){
        if(queue.isEmpty()){
            if(!sameDistance.isEmpty()){
                eatFish(currentTime);
            }
            return;
        }
/*

        System.out.println(queue.peek().toString());
        System.out.println("현재 셀의 물고기 크기 : " + queue.peek().cell.fish);
        System.out.println("현재 시점의 상어 크기 : " + sharkSize);
*/

        CellWrapper cellWrapper = queue.pop();
        Cell cell = cellWrapper.cell;

        int time = cellWrapper.time;

        // System.out.println("현재 시간 : "+currentTime);
        if (time>currentTime){
            currentTime = time;

            // System.out.println("입장해유 : "+sameDistance.toString());

            if(!sameDistance.isEmpty()){
                eatFish(time-1);    // 같은 거리 cell의 push가 끝난 뒤, time+1 상태에서 물고기를 먹으러 가므로 -1
                return;
            }
        }

        if (cell.fish>sharkSize && cell.fish!=9){
            bfs();
            return;
        }

        if (cell.fish!=0 && cell.fish<sharkSize){
            sameDistance.add(cell);
        }

        for(int i = 0; i<cell.cellList.size(); i++){
            Cell nextCell = cell.cellList.get(i);
            if(!visited[nextCell.row][nextCell.col] && (nextCell.fish<=sharkSize || nextCell.fish==9)){
                visited[nextCell.row][nextCell.col] = true;
                queue.add(new CellWrapper( time+1 , nextCell));
            }
        }

        bfs();
    }

    static void eatFish(int time){
        Collections.sort(sameDistance, (e1, e2)->{
            if(e2.row==e1.row){
                return e1.col-e2.col;
            }
            return e1.row-e2.row;
        });

        // System.out.println("같은 거리 모음 : " + sameDistance.toString());

        Cell cell = sameDistance.pop();

        // 먹는 부분
        if (cell.fish!= 0 && cell.fish<sharkSize){
            cellBox.get(cell.row).get(cell.col).fish = 0;
            count += time;
            visited = new boolean[N][N];

            eatCount++;
            if(eatCount==sharkSize){
                eatCount = 0;
                sharkSize++;
            }

            row = cell.row;
            col = cell.col;

            visited[row][col] = true;
            cell.fish = 0;

            queue = new LinkedList<>();
            queue.add(new CellWrapper(0, cell));

            sameDistance.clear();
            currentTime = 0;

            System.out.println();
            for(int i = 0 ; i<N; i++){
                for(int j = 0; j<N; j++){
                    if (i==row && j==col){
                        System.out.print("* ");
                    }else{
                        System.out.print(cellBox.get(i).get(j).fish+" ");
                    }
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("새 출발점은 " + row + "," + col + "입니다.");
            System.out.println("상어의 크기는 " + sharkSize + "입니다.");
            System.out.println("현재 먹이의 개수는 " + eatCount + "입니다.");
            // System.out.println(queue.peek().cell.cellList.toString()+"의 순서로 출발합니다.");
            System.out.println("추가된 시간은 : "+time + "입니다.");
            System.out.println("현재까지 걸린 시간은 : "+count + "입니다.");
        }
        bfs();
    }
}

class Cell{
    int row;
    int col;
    ArrayList<Cell> cellList = new ArrayList<>();
    int fish;
    boolean visited = false;
    Cell(int fish, int row, int col){
        this.fish = fish;
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "("+row+", " + col+")";
    }
}

class CellWrapper{
    int time;
    Cell cell;

    CellWrapper(int time, Cell cell){
        this.time = time;
        this.cell = cell;
    }

    @Override
    public String toString() {
        return "CellWrapper{" +
                "time=" + time +
                ", cell=" + cell +
                '}';
    }
}
/*
6
5 4 3 2 3 4
4 3 2 3 4 5
3 2 9 5 6 6
2 1 2 3 4 5
3 2 1 6 5 4
6 6 6 6 6 6


3
0 0 1
0 0 0
0 9 0

7
3 5 0 6 4 5 5
1 6 3 3 0 2 2
6 2 1 3 1 5 1
9 2 2 3 4 2 3
2 1 6 2 0 0 4
4 5 0 6 1 1 0
5 4 3 2 1 4 0


7
3 5 0 6 4 5 5
1 6 3 3 0 2 2
6 2 * 3 1 5 1
9 2 2 3 4 2 3
2 * 6 2 0 0 4
4 5 0 6 1 1 0
5 4 3 2 1 4 0

10
5 3 2 0 0 1 2 0 4 0
3 0 3 1 0 0 3 0 6 1
0 3 0 5 0 5 4 4 2 5
3 0 0 3 0 6 1 5 4 2
1 0 2 0 2 0 3 0 0 6
1 1 1 1 1 1 1 1 0 0
2 0 2 1 9 6 0 0 4 3
1 6 1 0 6 0 5 0 1 0
6 5 4 0 1 2 1 3 5 0
0 1 6 6 1 4 3 0 1 1

10
2 0 2 0 1 1 1 0 1 0
0 4 4 0 4 0 0 0 3 0
4 3 5 0 1 0 2 6 0 0
0 0 5 5 3 1 3 1 3 4
6 0 5 1 4 2 4 0 5 0
0 0 5 0 2 1 1 2 1 0
2 0 5 2 4 0 9 1 6 2
4 1 2 0 3 0 3 2 4 6
3 0 1 0 4 0 0 5 0 1
0 4 1 1 6 6 1 6 0 0


10
5 6 3 0 5 5 4 4 3 0
2 4 0 4 0 1 0 1 0 6
0 3 4 1 0 0 3 1 1 0
0 5 1 0 1 6 1 3 5 1
0 3 0 1 1 0 4 0 1 0
0 5 1 5 6 0 3 4 0 9
0 5 5 3 0 0 4 5 0 3
2 5 0 3 3 2 0 0 3 2
2 6 5 0 0 4 1 1 6 3
1 3 1 3 0 1 0 0 0 5
 */