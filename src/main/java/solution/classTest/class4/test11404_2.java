package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test11404_2 {
    static Long[][] costChart;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cities = Integer.parseInt(br.readLine());
        int buses = Integer.parseInt(br.readLine());

        costChart = new Long[cities][cities];

        StringTokenizer st;
        for(int i = 0 ; i<buses; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());

            if(costChart[from][to]==null){
                costChart[from][to] = (long) cost;
            }else{
                costChart[from][to] = Math.min( cost, costChart[from][to] );
            }
        }

        for(int i = 0 ; i<cities; i++){ // round
            for(int j = 0; j<cities; j++){ // 출발점
                for (int k = 0 ; k<cities; k++){ // 출발점 cost visited
                    if(j==k){
                        costChart[j][k] = (long) 0;
                    }

                    Long mid = costChart[j][i]; // 출발점 - 경유지 cost
                    Long to = costChart[i][k]; // 경유지 - 목표점 cost
                    if( mid!=null && to!=null ){
                        if( costChart[j][k] == null ){
                            costChart[j][k] = mid+to;
                        }else{
                            costChart[j][k] = Math.min( mid+to, costChart[j][k]);
                        }
                    }
                }
            }
        }

        for (int i = 0 ; i<cities; i++){
            for (int j = 0 ; j<cities; j++){
                Long value = costChart[i][j];
                if(value==null){
                    value = (long) 0;
                }
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
