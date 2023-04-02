package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test1916 {

    static int N;
    static int M;
    static int start;
    static int end;
    static Integer[] costBoard;
    static ArrayList<City> cityList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        costBoard = new Integer[N];
        visited = new boolean[N];

        for(int i = 0 ; i<N; i++){
            cityList.add(new City(i));
        }

        StringTokenizer st;
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());

            cityList.get(from).busList.add(new Bus(to, cost));
        }

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken())-1;
        end = Integer.parseInt(st.nextToken())-1;

        visited[start] = true;
        costBoard[start] = 0;

        updateBoard();

        System.out.println(costBoard[end]);
    }
    public static int getLowerCost(){
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for(int i = 0 ; i<N; i++){
            if(!visited[i] && costBoard[i]!=null && costBoard[i] < min ){
                min = costBoard[i];
                idx = i;
            }

            // System.out.println( (i) +"까지의 거리 " + costBoard[i]);
        }
        if(idx==-1){
            return idx;
        }
        visited[idx] = true;
        // System.out.println(min);
        return idx;
    }

    public static void updateBoard() {
        if(start == -1){
            return;
        }
        City city = cityList.get(start);
        ArrayList<Bus> busList = city.busList;

        // System.out.println("현재 방문 도시 : " + (city.cityNo));

        for(int i = 0; i <busList.size(); i++){
            int nextCity = busList.get(i).to;
            int plus = busList.get(i).cost + costBoard[start];
            if( costBoard[nextCity]==null || plus<costBoard[nextCity] ){
                costBoard[nextCity] = plus;
            }
        }

        start = getLowerCost();

        // System.out.println("다음 방문 도시 : " + (start));

        updateBoard();
    }
}

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
