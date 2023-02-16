package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test14500 {
    static int[][] board;
    static boolean[][] visited;

    static int N;
    static int M;

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i<N; i++){
            for(int j = 0; j<M; j++){
                centerBlock(i,j);
                foward(0, 0, i, j);
            }
        }
        System.out.println(max);
    }

    static void foward(int depth, int sum, int row, int col){
        if(depth==4){
            if(sum>max){
                max = sum;
            }
            return;
        }

        if(row-1>=0 && !visited[row-1][col]){
            visited[row-1][col] = true;
            foward(depth+1, sum + board[row-1][col], row-1, col);
            visited[row-1][col] = false;
        }
        if(row+1<N && !visited[row+1][col]){
            visited[row+1][col] = true;
            foward(depth+1, sum + board[row+1][col], row+1, col);
            visited[row+1][col] = false;
        }
        if(col-1>=0 && !visited[row][col-1]){
            visited[row][col-1] = true;
            foward(depth+1, sum + board[row][col-1], row, col-1);
            visited[row][col-1] = false;
        }
        if(col+1<M && !visited[row][col+1]){
            visited[row][col+1] = true;
            foward(depth+1, sum + board[row][col+1], row, col+1);
            visited[row][col+1] = false;
        }
    }

    static void centerBlock(int row, int col){
        int[] arr = new int[4];

        if(row-1>=0){ arr[0] = board[row-1][col]; }
        if(row+1<N){ arr[1] = board[row+1][col]; }
        if(col-1>=0){ arr[2] = board[row][col-1]; }
        if(col+1<M){ arr[3] = board[row][col+1]; }

        Arrays.sort(arr);

        int sum = board[row][col];

        for(int i = 1; i<4; i++){
            sum+= arr[i];
        }

        if(sum>max){
            max = sum;
        }
    }
}
