package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test14938 {

    static final int INF = 1000000000;
    static int n;
    static int m;
    static int r;
    static Integer totalItems = 0;
    static int max = 0;
    static int[] items;
    static int[][] chart;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int[n];
        chart = new int[n][n];

        for( int i = 0 ; i<n; i++){
            Arrays.fill(chart[i], INF);
            chart[i][i] = 0;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<n; i++){
            items[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());

            chart[from][to] = cost;
            chart[to][from] = cost;
        }

        floyd();

        for(int i = 0 ; i<n; i++){
            int total = 0;
            for(int j = 0 ; j<n; j++){
                if(chart[i][j] <= m){
                    total += items[j];
                }
            }
            max = Math.max(total, max);
        }

        System.out.println(max);
    }

    public static void floyd(){
        for(int i = 0 ; i<n; i++){          // 경유지
            for(int j = 0 ; j<n; j++){      // 출발지
                for(int k = 0; k<n; k++){   // 도착지
                    chart[j][k] = Math.min( chart[j][k], chart[j][i]+chart[i][k] );
                }
            }
        }
    }
}

