package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test1865 {

    // 경유지까지의 거리와 도착지까지의 거리가 모두 INF인 경우, INF=Integer.MAX_VALUE 사용시 overflow 발생
    static final int INF = 1000000000;
    static int N;
    static int M;
    static int W;
    static int[][] costBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0 ; i<T; i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            costBoard = new int[N][N];

            for(int j = 0; j<N; j++){
                Arrays.fill(costBoard[j], INF);
                costBoard[j][j] = 0;
            }

            for(int j = 0; j<M+W; j++){   // 도로 입력
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken())-1;
                int to = Integer.parseInt(st.nextToken())-1;
                int cost = Integer.parseInt(st.nextToken());

                if(j<M && cost<costBoard[to][from]){
                    costBoard[to][from] = cost;
                }

                if(j>=M){
                    cost *= -1;
                }

                if(cost<costBoard[from][to]){
                    costBoard[from][to] = cost;
                }
            }

            boolean check = updateBoard();

            String answer = check ? "YES" : "NO";

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean updateBoard(){
        for(int i = 0 ; i<N; i++){ // round ( 경유지 index )
            for(int j = 0 ; j<N; j++){ // 출발지
                for(int k = 0; k<N; k++){ // 도착지

                    int mid = costBoard[j][i];
                    int end = costBoard[i][k];

                    costBoard[j][k] = Math.min( costBoard[j][k], mid+end );
                    if(  j==k && mid+end < 0){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}