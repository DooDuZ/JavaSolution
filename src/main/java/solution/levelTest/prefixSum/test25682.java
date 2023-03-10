package solution.levelTest.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test25682 {
    static int[][] WB;
    static int[][] BW;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        WB = new int[N][M];
        BW= new int[N][M];

        for(int i = 0; i<N; i++){
            for(int j = 0 ; j<M; j++){
                if(i%2==0){
                    if(j%2==0){
                        WB[i][j] = 0;
                        BW[i][j] = 1;
                    }else{
                        WB[i][j] = 1;
                        BW[i][j] = 0;
                    }
                }else{
                    if(j%2==0){
                        WB[i][j] = 1;
                        BW[i][j] = 0;
                    }else{
                        WB[i][j] = 0;
                        BW[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 0 ; i<N; i++){
            String str = br.readLine();
            for(int j = 0 ; j<M; j++){
                int color = str.charAt(j)=='B' ? 0 : 1;
                if(i==0 && j==0){
                    WB[i][j] = WB[i][j]==color ? 0 : 1;
                    BW[i][j] = BW[i][j]==color ? 0 : 1;
                }else if(i==0){
                    WB[i][j] = WB[i][j]==color ? 0 : 1;
                    WB[i][j] += WB[i][j-1];
                    BW[i][j] = BW[i][j]==color ? 0 : 1;
                    BW[i][j] += BW[i][j-1];
                }else if(j==0){
                    WB[i][j] = WB[i][j]==color ? 0 : 1;
                    WB[i][j] += WB[i-1][j];
                    BW[i][j] = BW[i][j]==color ? 0 : 1;
                    BW[i][j] += BW[i-1][j];
                }else{
                    WB[i][j] = WB[i][j]==color ? 0 : 1;
                    WB[i][j] += (WB[i-1][j] + WB[i][j-1] - WB[i-1][j-1]);
                    BW[i][j] = BW[i][j]==color ? 0 : 1;
                    BW[i][j] += (BW[i-1][j] + BW[i][j-1] - BW[i-1][j-1]);
                }
            }
        }
        /*
        System.out.println("=====================WB=====================");
        for(int i = 0 ; i<N; i++){
            for(int j = 0 ; j<M; j++){
                System.out.print( WB[i][j] + " " );
            }
            System.out.println();
        }

        System.out.println("=====================BW=====================");
        for(int i = 0 ; i<N; i++){
            for(int j = 0 ; j<M; j++){
                System.out.print( BW[i][j] + " " );
            }
            System.out.println();
        }
        */

        int answer = Integer.MAX_VALUE;

        for(int i = 0 ; i<=N-K; i++){
            for (int j = 0 ; j<=M-K; j++){
                answer = Math.min( answer, Math.min(getCount(WB, i ,j, K-1), getCount(BW, i, j, K-1)) );
            }
        }

        System.out.println(answer);
    }

    public static int getCount(int[][] board, int row, int col, int k){
        int ret = board[row+k][col+k];

        if(row-1>=0){
            ret -= board[row-1][col+k];
        }

        if(col-1>=0){
            ret -= board[row+k][col-1];
        }

        if(row-1>=0 && col-1>=0){
            ret += board[row-1][col-1];
        }

        // System.out.println(ret);
        return ret;
    }
}
