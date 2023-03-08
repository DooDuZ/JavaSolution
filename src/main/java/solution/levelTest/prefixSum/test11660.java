package solution.levelTest.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test11660 {
    static int[][] arr;

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for(int i = 0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                int el = Integer.parseInt(st.nextToken());

                if(j==0){
                    arr[i][j] = el;
                }else{
                    arr[i][j] = arr[i][j-1] + el;
                }
            }
        }

        for(int i = 0 ; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int sRow = Integer.parseInt(st.nextToken())-1;
            int sCol = Integer.parseInt(st.nextToken())-1;
            int eRow = Integer.parseInt(st.nextToken())-1;
            int eCol = Integer.parseInt(st.nextToken())-1;

            sb.append(sumArray(sRow, sCol, eRow, eCol)).append("\n");
        }

        System.out.println(sb);
    }

    public static int sumArray(int sRow, int sCol, int eRow, int eCol){
        int ret = 0;

        for(int i = 0 ; i<=eRow-sRow; i++){
            if( sCol!=0 ){
                ret += arr[sRow+i][eCol] - arr[sRow+i][sCol-1] ;
            }else{
                ret += arr[sRow+i][eCol];
            }
        }
        return ret;
    }
}
