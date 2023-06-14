package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test2887 {
    static int N;
    static ArrayList<Planet> planets = new ArrayList<>();

    static long answer = 0;
    static boolean[] visited;
    static PriorityQueue<Tunnel> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N];

        for(int i = 0 ; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets.add(new Planet(i, x, y, z));
        }
        // x축 정렬
        Collections.sort(planets, (e1,e2) -> {
            return e1.x-e2.x;
        });

        for(int i = 0 ; i<N-1; i++){
            Planet o1 = planets.get(i);
            Planet o2 = planets.get(i+1);
            // 다른 사람들의 풀이 (x,y,z의 거리만 구함)
            // 이 풀이가 왜 되는지 이해를 못하는중...
            int cost = Math.abs(o1.x-o2.x);
            // 내 풀이 ( 노드간의 거리를 구함 )
            // int cost = getDistance(o1,o2);
            // 살짝 느리긴하지만 유의미한 차이가 나지는 않는다. 둘 다 통과 된다.

            o1.tunnels.add(new Tunnel(o2.idx, cost));
            o2.tunnels.add(new Tunnel(o1.idx, cost));
        }

        // y축 정렬
        Collections.sort(planets, (e1,e2) -> {
            return e1.y-e2.y;
        });

        for(int i = 0 ; i<N-1; i++){
            Planet o1 = planets.get(i);
            Planet o2 = planets.get(i+1);
            int cost = Math.abs(o1.y-o2.y);

            o1.tunnels.add(new Tunnel(o2.idx, cost));
            o2.tunnels.add(new Tunnel(o1.idx, cost));
        }

        // z축 정렬
        Collections.sort(planets, (e1,e2) -> {
            return e1.z-e2.z;
        });

        for(int i = 0 ; i<N-1; i++){
            Planet o1 = planets.get(i);
            Planet o2 = planets.get(i+1);
            int cost = Math.abs(o1.z-o2.z);;

            o1.tunnels.add(new Tunnel(o2.idx, cost));
            o2.tunnels.add(new Tunnel(o1.idx, cost));
        }

        Collections.sort(planets, (e1,e2) -> {
            return e1.idx - e2.idx;
        });

        pq.add(new Tunnel(planets.get(0).idx, 0));

        prim();

        System.out.println(answer);
    }

    public static void prim(){
        while(!pq.isEmpty()){
            Tunnel cur = pq.poll();

            if(visited[cur.v]){ continue; }

            visited[cur.v] = true;
            answer += cur.c;

            Planet p = planets.get(cur.v);

            for(Tunnel t : p.tunnels){
                if(visited[t.v]){ continue; }
                pq.add(t);
            }
        }
    }

    static public int getDistance(Planet o1, Planet o2 ){
        int ret = Math.min( Math.abs(o1.x-o2.x), Math.abs(o1.y-o2.y) );
        ret = Math.min( ret, Math.abs(o1.z-o2.z) );
        return ret;
    }
}


class Planet{
    int idx;
    int x;
    int y;
    int z;

    ArrayList<Tunnel> tunnels = new ArrayList<>();

    Planet(int idx, int x, int y, int z){
        this.idx = idx;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Tunnel implements Comparable<Tunnel>{
    int v;
    int c;

    Tunnel(int v, int c){
        this.v = v;
        this.c = c;
    }

    @Override
    public int compareTo(Tunnel o){
        return this.c-o.c;
    }
}