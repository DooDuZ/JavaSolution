package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test12851 {

    static int N;
    static int K;
    static Integer[] visited = new Integer[100001];
    static LinkedList<Integer[]> queue = new LinkedList<>();

    static int min_time = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited[N] = 0;
        queue.add(new Integer[]{ N, 0 });
        bfs();

        System.out.println(min_time);
        System.out.println(count);
    }

    public static void bfs(){
        if(queue.isEmpty()){
            return;
        }

        Integer[] nodeValue = queue.pop();

        int position = nodeValue[0];
        int time = nodeValue[1];


        //System.out.println("현재 위치 : "+position);
        //System.out.println("경과 시간 : "+time);

        if(time>min_time){
            bfs();
            return;
        }

        if(position==K){
            if(min_time > time){
                min_time = time;
                count = 1;
            }else{
                count++;
            }
        }

        int plusValue = position + 1;
        int minusValue = position - 1;
        int doubleValue = position * 2;

        if( plusValue < 100001 && ( visited[plusValue] == null || visited[plusValue] >= time+1 )){
            visited[plusValue] = time+1;
            queue.add(new Integer[]{plusValue, time+1});
        }

        if( minusValue >= 0 && ( visited[minusValue] == null || visited[minusValue] >= time+1 )){
            visited[minusValue] = time+1;
            queue.add(new Integer[]{minusValue, time+1});
        }

        if( doubleValue < 100001 && ( visited[doubleValue] == null || visited[doubleValue] >= time+1 )){
            visited[doubleValue] = time+1;
            queue.add(new Integer[]{doubleValue, time+1});
        }

        bfs();
    }
}
