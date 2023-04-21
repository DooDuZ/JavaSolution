package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


// 메모리 초과
    // 재도전...예정..
public class test2206 {
    static int N;
    static int M;
    static int[][] map;

    static LinkedList<Integer[]> queue = new LinkedList<>();
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M][2];

        for( int i = 0 ; i<N; i++){
            String line = br.readLine();
            for(int j = 0 ; j<M; j++){
                map[i][j] = line.charAt(j)-'0';
            }
        }

        for(int i = 0 ; i<N; i++){
            for(int j = 0 ; j<M; j++){
                visited[i][j][0] = Integer.MAX_VALUE;
            }
        }

        visited[0][0][0] = 1;
        visited[0][0][1] = 1;
        queue.add(new Integer[]{0,0,1,1});
        bfs();

        if(visited[N-1][M-1][0]==Integer.MAX_VALUE){
            visited[N-1][M-1][0] = -1;
        }
        System.out.println(visited[N-1][M-1][0]);
    }

    public static void bfs(){
        if(queue.isEmpty()){
            return;
        }

        Integer[] position = queue.pop();

        int row = position[0];
        int col = position[1];
        int distance = position[2];
        int pass = position[3];

        if(row==0 && col==0){
            System.out.println(row + ", " + col + " 까지의 거리는 " + distance + "이며 통행권은 " + pass + "개 남았습니다.");
        }
        distance++;

        if(row-1>=0 && ( (visited[row-1][col][0] > distance) || (visited[row-1][col][0] == distance && pass>visited[row-1][col][1]) ) ){
            int nextP = setPass(row-1, col, pass);
            if( map[row-1][col] == 0 || ( map[row-1][col] == 1 && nextP >=0 ) ){
                visited[row-1][col][0] = distance;
                visited[row-1][col][1] = pass;
                queue.add(new Integer[]{row-1, col, distance, nextP});
            }
        }

        if(row+1<N && ( (visited[row+1][col][0] > distance) || (visited[row+1][col][0] == distance && pass>visited[row+1][col][1]) ) ){
            int nextP = setPass(row+1, col, pass);
            if( map[row+1][col] == 0 || ( map[row+1][col] == 1 && nextP >=0 ) ){
                visited[row+1][col][0] = distance;
                visited[row+1][col][1] = pass;
                queue.add(new Integer[]{row+1, col, distance, nextP});
            }
        }

        if(col-1>=0 && ( (visited[row][col-1][0] > distance) || (visited[row][col-1][0] == distance && pass>visited[row][col-1][1]) ) ){
            int nextP = setPass(row, col-1, pass);
            if( map[row][col-1] == 0 || ( map[row][col-1] == 1 && nextP >=0 ) ){
                visited[row][col-1][0] = distance;
                visited[row][col-1][1] = pass;
                queue.add(new Integer[]{row, col-1, distance, nextP});
            }
        }

        if(col+1<M && ( (visited[row][col+1][0] > distance) || (visited[row][col+1][0] == distance && pass>visited[row][col+1][1]) ) ){
            int nextP = setPass(row, col+1, pass);
            if( map[row][col+1] == 0 || ( map[row][col+1] == 1 && nextP >=0 ) ){
                visited[row][col+1][0] = distance;
                visited[row][col+1][1] = pass;
                queue.add(new Integer[]{row, col+1, distance, nextP});
            }
        }

        bfs();
    }

    public static int setPass(int row, int col, int pass){
        if( map[row][col] == 1 ){
            pass--;
        }
        return pass;
    }
}
/*
6 4
0000
1110
1000
0000
0111
0000

 */