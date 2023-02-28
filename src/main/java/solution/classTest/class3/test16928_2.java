package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test16928_2 {

    static ArrayList<Gate> list = new ArrayList<>();

    static LinkedList<Integer[]> queue = new LinkedList<>();

    static boolean[] visited = new boolean[101];

    static int minimum = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list.add(null);

        for(int i = 1; i<=100; i++){
            list.add(new Gate(i));
        }

        for(int i = 0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            int endpoiont = Integer.parseInt(st.nextToken());
            int type = 1;

            Gate gate = list.get(position);

            gate.type = type;
            gate.endPoint = endpoiont;
        }

        for(int i = 0 ; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            int endpoiont = Integer.parseInt(st.nextToken());
            int type = 2;

            Gate gate = list.get(position);

            gate.type = type;
            gate.endPoint = endpoiont;
        }

        visited[1] = true;
        queue.add(new Integer[]{1, 0});

        bfs();

        System.out.println(minimum);
    }

    public static void bfs(){
        if(queue.isEmpty()){
            return;
        }

        Integer[] arr = queue.pop();

        int position = arr[0];
        int count = arr[1];

        // System.out.println( position+"위치까지 " + count + " 번 던짐");

        if(position==100){
            minimum = Math.min(minimum, count);
        }else if(position>=94){
            minimum = Math.min(minimum, count+1);
        }

        for(int i = 1 ; i<=6; i++){

            int nextPosition = position+i;
            if(nextPosition>100){
                continue;
            }

            if(list.get(nextPosition).type!=0){
                nextPosition = list.get(nextPosition).endPoint;
            }

            if(!visited[nextPosition]){
                visited[nextPosition] = true;
                queue.add(new Integer[]{nextPosition, count+1});
            }
        }

        bfs();
    }
}


class Gate{
    int type = 0;
    int position;
    int endPoint;
    Gate(int position){
        this.position = position;
        this.endPoint = position;
    }
}
