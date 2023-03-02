package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test7569 {
    static int N;
    static int M;
    static int H;

    static Integer[][][] storage;

    static boolean[][][] visited;

    static LinkedList<Integer[]> queue = new LinkedList<>();

    static int count = 0;

    static int finalDays = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        storage = new Integer[H][N][M];
        visited = new boolean[H][N][M];

        for(int i = 0 ; i<H ; i++){
            for(int j = 0 ; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0 ; k<M; k++){
                    storage[i][j][k] = Integer.parseInt(st.nextToken());
                    if(storage[i][j][k]==0){
                        count++;
                    }
                }
            }
        }

        for(int i = 0 ; i<H ; i++){
            for(int j = 0 ; j<N; j++){
                for(int k = 0 ; k<M; k++){
                    if(!visited[i][j][k] && storage[i][j][k] == 1){
                        visited[i][j][k] = true;
                        queue.add(new Integer[]{ i,j,k,0 });
                        count++;
                    }
                }
            }
        }

        bfs();

        // System.out.println("최종 count : " + count);

        if(count!=0){
            System.out.println(-1);
        }else{
            System.out.println(finalDays);
        }

    }

    static void bfs(){
        if(queue.isEmpty()){
            return;
        }

        Integer[] tomato = queue.pop();

        int height = tomato[0];
        int row = tomato[1];
        int col = tomato[2];
        int day = tomato[3];

        // System.out.println(count);
        count--;
        //System.out.println(height +", "+row +", "+col +", "+day +", ");

        finalDays = Math.max(finalDays, day);

        // 위 아래
        if( height-1>=0 && !visited[height-1][row][col] && storage[height-1][row][col]==0 ){
            visited[height-1][row][col] = true;
            queue.add( new Integer[]{ height-1, row, col, day+1 } );
        }
        if( height+1<H && !visited[height+1][row][col] && storage[height+1][row][col]==0 ){
            visited[height+1][row][col] = true;
            queue.add( new Integer[]{ height+1, row, col, day+1 } );
        }

        // 남 북
        if( row-1>=0 && !visited[height][row-1][col] && storage[height][row-1][col]==0 ){
            visited[height][row-1][col] = true;
            queue.add( new Integer[]{ height, row-1, col, day+1 } );
        }

        if( row+1<N && !visited[height][row+1][col] && storage[height][row+1][col]==0 ){
            visited[height][row+1][col] = true;
            queue.add( new Integer[]{ height, row+1, col, day+1 } );
        }

        // 동 서
        if( col-1>=0 && !visited[height][row][col-1] && storage[height][row][col-1]==0 ){
            visited[height][row][col-1] = true;
            queue.add( new Integer[]{ height, row, col-1, day+1 } );
        }

        if( col+1<M && !visited[height][row][col+1] && storage[height][row][col+1]==0 ){
            visited[height][row][col+1] = true;
            queue.add( new Integer[]{ height, row, col+1, day+1 } );
        }

        bfs();
    }
}

/*
100 2 1
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1

8 1 1
1 0 0 0 0 0 0 1

 */