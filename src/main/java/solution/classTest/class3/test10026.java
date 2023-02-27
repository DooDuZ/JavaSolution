package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class test10026 {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static LinkedList<Integer[]> queue = new LinkedList<>();

    static int block = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        for(int i  = 0 ;i<N; i++){
            String str = br.readLine();
            for(int j = 0 ; j<N; j++){
                board[i][j] = str.charAt(j); // RGB char로 구분하여 사용
            }
        }

        for(int i = 0 ; i<N; i++){
            for(int j = 0 ; j<N; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    queue.add(new Integer[]{i,j});
                    bfs();
                }
            }
        }

        int RGB = block;
        block = 0;
        for(int i = 0; i<N; i++) {
            Arrays.fill(visited[i], false);
        }

        for(int i = 0 ; i<N; i++){
            for(int j = 0 ; j<N; j++){
                if(board[i][j]=='R'){
                    board[i][j]='G';
                }
            }
        }

        for(int i = 0 ; i<N; i++){
            for(int j = 0 ; j<N; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    queue.add(new Integer[]{i,j});
                    bfs();
                }
            }
        }

        int GB = block;

        System.out.println(RGB + " " + GB);
    }

    static void bfs(){
        if(queue.isEmpty()){
            block++;
            return;
        }

        Integer[] arr = queue.pop();
        int row = arr[0];
        int col = arr[1];

        if( row-1>=0 && !visited[row-1][col] && board[row-1][col] == board[row][col] ){
            visited[row-1][col] = true;
            queue.add( new Integer[]{row-1, col} );
        }

        if( row+1<N && !visited[row+1][col] && board[row+1][col] == board[row][col] ){
            visited[row+1][col] = true;
            queue.add( new Integer[]{row+1, col} );
        }

        if( col-1>=0 && !visited[row][col-1] && board[row][col-1] == board[row][col] ){
            visited[row][col-1] = true;
            queue.add( new Integer[]{row, col-1} );
        }

        if( col+1<N && !visited[row][col+1] && board[row][col+1] == board[row][col] ){
            visited[row][col+1] = true;
            queue.add( new Integer[]{row, col+1} );
        }

        bfs();
    }
}
