package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test2638 {

    static int N;
    static int M;

    static int[][] paper;
    static boolean[][] visited;

    static LinkedList<Integer[]> queue = new LinkedList<>();

    static LinkedList<Integer[]> cheeseQueue = new LinkedList<>();

    static int total = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j<M; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
                if(paper[i][j]==1){
                    total++;
                }
            }
        }

        //System.out.println("녹아야할 치즈의 개수 : " + total);

        visited[0][0] = true;
        queue.add(new Integer[]{0,0});
        bfs();
/*
        System.out.println("==========================================");
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(paper[i][j]==-1 || paper[i][j]==-2){
                    System.out.print(paper[i][j]+" ");
                }else{
                    System.out.print(" "+paper[i][j]+" ");
                }
            }
            System.out.println();
        }
        System.out.println("==========================================");
*/
        while (total>0){
            count++;
            deleteCheese();
            bfs();
        }

        System.out.println(count);
    }

    public static void deleteCheese(){
        for(int i = 0 ; i<N; i++){
            for(int j = 0; j<M; j++){
                int outCount = 0;
                if(!visited[i][j] && paper[i][j]==1){
                    if(i-1>=0 && paper[i-1][j]==-1){ outCount++; }
                    if(i+1<N && paper[i+1][j]==-1){ outCount++; }
                    if(j-1>=0 && paper[i][j-1]==-1){ outCount++; }
                    if(j+1<M && paper[i][j+1]==-1){ outCount++; }
                }
                if(outCount>=2){
                    visited[i][j] = true;
                    cheeseQueue.add(new Integer[]{i,j});
                    total--;
                }
            }
        }
        while(!cheeseQueue.isEmpty()){
            Integer[] melting = cheeseQueue.pop();

            int row = melting[0];
            int col = melting[1];

            paper[row][col] = -1;

            if( row-1 >= 0 && !visited[row-1][col] && paper[row-1][col]==0 ){
                visited[row-1][col] = true;
                queue.add( new Integer[]{row-1, col} );
            }
            if( row+1 < N && !visited[row+1][col] &&  paper[row+1][col]==0 ){
                visited[row+1][col] = true;
                queue.add( new Integer[]{row+1, col} );
            }
            if( col-1 >=0 && !visited[row][col-1]  && paper[row][col-1]==0 ){
                visited[row][col-1] = true;
                queue.add( new Integer[]{row, col-1} );
            }
            if( col+1 < M && !visited[row][col+1]  && paper[row][col+1]==0 ){
                visited[row][col+1] = true;
                queue.add( new Integer[]{row, col+1} );
            }
        }
    }

    public static void bfs(){
        if(queue.isEmpty()){
            return;
        }

        Integer[] cell = queue.pop();
        int row = cell[0];
        int col = cell[1];

        paper[row][col] = -1;

        if( row-1>=0 && !visited[row-1][col] && paper[row-1][col]==0 ){
            visited[row-1][col] = true;
            queue.add(new Integer[]{row-1, col});
        }
        if( row+1<N && !visited[row+1][col] && paper[row+1][col]==0 ){
            visited[row+1][col] = true;
            queue.add(new Integer[]{row+1, col});
        }
        if( col-1>=0 && !visited[row][col-1] && paper[row][col-1]==0 ){
            visited[row][col-1] = true;
            queue.add(new Integer[]{row, col-1});
        }
        if( col+1<M && !visited[row][col+1] && paper[row][col+1]==0 ){
            visited[row][col+1] = true;
            queue.add(new Integer[]{row, col+1});
        }

        bfs();
    }
}

/*
8 9
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 1 0 0 0 1 1 0
0 1 0 1 1 1 0 1 0
0 1 0 0 1 0 0 1 0
0 1 0 1 1 1 0 1 0
0 1 1 0 0 0 1 1 0
0 0 0 0 0 0 0 0 0
 */