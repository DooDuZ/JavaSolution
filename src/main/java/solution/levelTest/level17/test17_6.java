package solution.levelTest.level17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test17_6 {

    static int N;
    static int[][] price;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        price = new int[N][3];

        for(int i = 0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            price[i][0] = Integer.parseInt(st.nextToken());
            price[i][1] = Integer.parseInt(st.nextToken());
            price[i][2] = Integer.parseInt(st.nextToken());
        }

    }

    static void dfs(int depth, int value){
        if(depth == N || value>=min){
            min = Math.min(min, value);
            return;
        }
        for(int i = 0; i<N; i++){
            for(int j = 0; j<3; j++){
                dfs(depth + 1, value += price[i][j]);
            }
        }
    }
}
