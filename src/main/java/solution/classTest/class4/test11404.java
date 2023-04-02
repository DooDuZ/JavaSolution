package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


// 당연히 시간초과
 // 단순 dp로도 훨씬 최적화 시킬 수 있을 것 같다
    // 플로이드-워셜 이라는 알고리즘이 있다고함
    // 해당 방법으로 재작성
public class test11404 {
    static int cities;
    static ArrayList<City> cityList = new ArrayList<>();
    static int buses;

    static long min_cost = Long.MAX_VALUE;
    static Long[][] dp;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        cities = Integer.parseInt(br.readLine());
        buses = Integer.parseInt(br.readLine());

        dp = new Long[cities][cities];
        visited = new boolean[cities];

        for(int i = 0; i<cities; i++){
            cityList.add(new City(i));
        }

        StringTokenizer st;
        for(int i = 0 ; i<buses; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            cityList.get(from).busList.add( new Bus( to, cost) );
        }

        for(int i = 0; i<cities; i++){
            dp[i][i] = (long) 0;
        }

        for(int i = 0 ; i<cities; i++){
            for(int j = 0 ; j<cities; j++){
                move(i,j);
            }
        }

        for(int i = 0 ; i<cities; i++){
            for (int j = 0 ; j<cities; j++){
                sb.append(dp[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static long move(int from, int to){
        if(dp[from][to] == null){
            visited[from] = true;
            dfs(from, to, 0);
            visited[from] = false;
            dp[from][to] = min_cost;
            min_cost = Long.MAX_VALUE;
        }
        return dp[from][to];
    }

    public static void dfs(int from, int to, long cost){
        if(from==to || cost>min_cost){
            min_cost = Math.min(cost, min_cost);
            return;
        }
        ArrayList<Bus> busList = cityList.get(from).busList;
        for (int i = 0; i<busList.size(); i++){
            Bus bus = busList.get(i);
            int nextCity = bus.to;
            if(!visited[nextCity]){
                visited[nextCity] = true;
                dfs(nextCity, to, cost + bus.cost);
                visited[nextCity] = false;
            }
        }
    }
}

/*

1916번 문제로 이동

class City{
    int cityNo;
    ArrayList<Bus> busList = new ArrayList<>();

    City(int cityNo){
        this.cityNo = cityNo;
    }
}

class Bus{
    int to;
    int cost;

    Bus(int to, int cost){
        this.to = to;
        this.cost = cost;
    }
}
*/