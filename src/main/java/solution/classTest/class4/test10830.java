package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test10830 {
    static int N;
    static int[][] initial;
    static long B;
    static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        initial = new int[N][N];

        for(int i = 0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                initial[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = pow(initial , B);

        for(int i = 0 ; i<N; i++){
            for(int j = 0 ; j<N; j++){
                sb.append(answer[i][j]%1000).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static int[][] pow(int[][] matrix, long idx){
        if(idx==1){
            return matrix;
        }

        int[][] ret = pow(matrix, idx/2);

        ret = multiply(ret, ret);

        if(idx%2==1){
            ret = multiply(ret, matrix);
        }

        return ret;
    }

    public static int[][] multiply(int[][] first, int[][] second){
        int[][] ret = new int[N][N];

        for(int i = 0 ; i<N; i++){
            for(int j = 0; j<N; j++){
                for(int k = 0 ; k<N; k++){
                    ret[i][j] += first[i][k] * second[k][j];
                    ret[i][j] %= 1000;
                }
            }
        }
        return ret;
    }
}

/*
2 1
1000 1000
1000 1000

하고

2 100000000000
999 998
997 996
 */