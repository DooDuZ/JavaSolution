package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;


// ULRD 순서로 찾고 해결하기
    // 이렇게 풀면 안된다고 한다... 아이고...
public class test16236 {

    static ArrayList<ArrayList<Cell>> cellBox = new ArrayList<>();
    static LinkedList<CellWrapper> queue = new LinkedList<>();

    static boolean[][] visited;

    static int row;
    static int col;

    static int N;

    static int count = 0;

    static int eatCount = 0;
    static int sharkSize = 2;

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

        for(int i = 0 ; i<N; i++){
            for(int j = 0; j<N; j++){
                System.out.print(cellBox.get(i).get(j).fish+" ");
            }
            System.out.println();
        }
    }

    static void bfs(){
        if(queue.isEmpty()){
            return;
        }

        System.out.println("돌아용");
        System.out.println(queue.peek().toString());

        CellWrapper cellWrapper = queue.pop();
        Cell cell = cellWrapper.cell;

        int time = cellWrapper.time;

        if (cell.fish>sharkSize && cell.fish!=9){ return; }
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

            System.out.println("새 출발점은 " + row + "," + col + "입니다.");
            System.out.println("상어의 크기는 " + sharkSize + "입니다.");
            System.out.println("현재 먹이의 개수는 " + eatCount + "입니다.");
            System.out.println(queue.peek().cell.cellList.toString()+"의 순서로 출발합니다.");

            bfs();

            return;
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