package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test2206_2 {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][][] visited;

    static int answer = Integer.MAX_VALUE;
    static LinkedList<Integer[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for( int i = 0 ; i<N; i++){
            String line = br.readLine();
            for(int j = 0 ; j<M; j++){
                map[i][j] = line.charAt(j)-'0';
            }
        }

        visited[0][0][1] = true;
        queue.add(new Integer[]{0,0,1,1});

        bfs();

        if(answer==Integer.MAX_VALUE){
            answer = -1;
        }
        System.out.println(answer);
    }

    public static void bfs(){
        if(queue.isEmpty()){
            return;
        }

        Integer[] value = queue.pop();

        int row = value[0];
        int col = value[1];
        int distance = value[2];
        int pass = value[3];

        if(row==N-1 && col==M-1){
            answer = Math.min(distance, answer);
        }

        distance++;

        System.out.println(row+", "+ col);

        addData(row-1, col, distance, pass);
        addData(row+1, col, distance, pass);
        addData(row, col-1, distance, pass);
        addData(row, col+1, distance, pass);

        bfs();
    }

    public static void addData(int row, int col, int distance, int pass){
        if(row<0 || row>=N || col<0 || col>=M){
            return;
        }

        if(map[row][col]==0){
            if(!visited[row][col][pass]) {
                visited[row][col][pass] = true;
                queue.add(new Integer[]{ row, col, distance, pass });
            }
        }else{
            if(pass==1 && !visited[row][col][pass]){
                visited[row][col][pass] = true;
                queue.add(new Integer[]{ row, col, distance, pass-1 });
            }
        }
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