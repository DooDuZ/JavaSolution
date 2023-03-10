package solution.levelTest.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class test13305 {

    static int cities;
    static ArrayList<City> cityList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cities = Integer.parseInt(br.readLine());

        for(int i = 0 ; i<cities; i++){
            cityList.add(new City());
        }

        for(int i = 0 ; i<cities-1; i++){
            cityList.get(i).next = cityList.get(i+1);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] distances = new int[cities-1];
        int[] costs = new int[cities];

        for (int i  = 0 ; i<cities-1; i++){
            distances[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i  = 0 ; i<cities; i++){
            costs[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i<cities; i++){
            City city = cityList.get(i);
            if(i!=cities-1){
                city.distance = distances[i];
            }
            city.fuelCost = costs[i];
        }

        System.out.println(getCost());
    }

    public static long getCost(){
        long ret = 0;

        int pointer = 0;
        long distance = 0;
        int currentCost = cityList.get(pointer).fuelCost;
        boolean isLast = true;

        while (pointer<cities && isLast){
            while ( cityList.get(pointer).fuelCost >= currentCost ){
                distance += cityList.get(pointer).distance;
                pointer++;
                if( pointer == cities ){
                    ret += currentCost*distance;
                    isLast = false;
                    break;
                }
            }
            if(isLast){
                ret += currentCost*distance;
                currentCost = cityList.get(pointer).fuelCost;
                distance = 0;
            }
        }
        return ret;
    }
}

class City{
    City next;
    int distance;
    int fuelCost;

    City(){}
}