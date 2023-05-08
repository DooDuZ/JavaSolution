package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test13549 {

    static boolean[] visited = new boolean[100001];

    static PriorityQueue<Integer[]> pq = new PriorityQueue<>((e1,e2)->{
        return e1[1]-e2[1];
    });

    static int N;
    static int K;

    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N>K){
            answer = N-K;
        }else{
            pq.add(new Integer[]{ K, 0 });
            bfs();
        }

        System.out.println(answer);
    }

    public static void bfs(){
        if(pq.isEmpty()){
            return;
        }

        Integer[] position = pq.poll();

        int cur = position[0];
        int distance = position[1];

        if(visited[cur]){
            bfs();
            return;
        }
        visited[cur] = true;

        if(cur==N){
            answer = distance;
            return;
        }

        if( cur%2==0 && cur!=0 && cur/2 >= 0 && !visited[cur/2] ){
            pq.add( new Integer[]{ cur/2, distance } );
        }

        if( cur-1 >= 0 && !visited[cur-1] ){
            pq.add( new Integer[]{ cur-1, distance+1 });
        }

        if( cur+1 < 100001 && !visited[cur+1] ){
            pq.add( new Integer[]{ cur+1, distance+1 });
        }
        bfs();
    }
}

/*

테스트 해본 케이스

테스트1: 0 0

답: 0

테스트2: 5 5

답: 0

테스트3: 100000 0

답: 100000

테스트4: 25000 100000

답: 0

테스트5: 2 1024

답: 0

테스트6: 99999 100000

답: 1

 */