package solution.programmers;
import java.util.*;

// 다익스트라를 변형해서 사용
    // 거리를 더하는 게 아니라, 현재까지의 최대 cost vs pq에 넣는 edge의 cost를 비교했다.
    // 로직에 문제가 있는지 시간 초과가 난다.
    // 같은 노드가 여러번 들어가지 않도록, 삽입 전 1번. 삽입 후 node를 꺼낼 때 한번 제어했으나 여전히 시간초과다.

    // pq -> queue로 바꾸면 23번이 아주 느리게 통과가 된다 (6000ms)
    // 따져보면 최단거리부터 접근해야하는 경로의 총 길이와는 달리, 이번 케이스는 지나온 간선의 값 중 최대 값만 가져오면 되기 때문에 pq를 고집할 필요가 없다.
    // 아니다.. 최단거리부터 꺼내야 로직에 이상이 생긴다. 적어도 내가 구현한 방식에선 pq가 필요함...

    // 해결
    // 기존 방법 -> 모든 출발점에서 다익스트라를 진행하며, 그때마다 거리를 저장하는 새로운 배열을 사용함
        // 출발점만큼의 탐색 반복이 발생
    // 바꾼 방법 -> 모든 출발점에서의 다익스트라를 진행하되, 전역 변수로 거리 배열을 두고 그 배열에 대해서만 값을 업데이트 한다.
        // 어짜피 최소값만 필요하기 때문에, 로직이 진행될 때마다 새로운 값을 계산하고 그중에 최소값을 찾고... 하는 방식이 필요가 없다.
        // 최소값을 갱신할 때만 로직 전체가 흐르기 때문에, 시간이 정말 말도안되게 빨라진다...
public class Kakao2022_hikingCourse_v2 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 6;
        int[][] paths = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
        int[] gates = {1,3};
        int[] summits = {5};

        int[] answer = solution.solution(n,paths,gates,summits);

        System.out.println(answer[0] + ", " + answer[1]);
    }
}

class Solution {

    class Edge implements Comparable<Edge>{
        int visit;
        int cost;

        Edge(int visit, int cost){
            this.visit = visit;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge edge){
            if(this.cost == edge.cost){
                return this.visit - edge.visit;
            }
            return this.cost - edge.cost;
        }
    }

    PriorityQueue<Edge> queue = new PriorityQueue<>();

    ArrayList<ArrayList<Edge>> edgeList = new ArrayList<>();

    int idx = 0;
    int cost = Integer.MAX_VALUE;

    boolean[] isGate;
    boolean[] isSummit;
    int[] chart;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        isGate = new boolean[n];
        isSummit = new boolean[n];
        chart = new int[n];
        Arrays.fill(chart, Integer.MAX_VALUE);

        for(int i = 0 ; i<n; i++){
            edgeList.add(new ArrayList<>());
        }

        for(int i = 0 ; i<gates.length; i++){
            isGate[gates[i]-1] = true;
        }

        for(int i = 0 ; i<summits.length; i++){
            isSummit[summits[i]-1] = true;
        }

        for(int i = 0; i<paths.length; i++){
            int from = paths[i][0]-1;
            int to = paths[i][1]-1;
            int cost = paths[i][2];

            if(isGate[from]){
                edgeList.get(from).add(new Edge(to, cost));
            }else if(isGate[to]){
                edgeList.get(to).add(new Edge(from, cost));
            }else if(isSummit[from]){
                edgeList.get(to).add(new Edge(from, cost));
            }else if(isSummit[to]){
                edgeList.get(from).add(new Edge(to, cost));
            }else{
                edgeList.get(from).add(new Edge(to, cost));
                edgeList.get(to).add(new Edge(from, cost));
            }
        }
        /*
        for(int i = 0 ; i<n; i++){
            Collections.sort( edgeList.get(i) );
        }
        */

        for(int i = 0 ; i<gates.length; i++){
            boolean[] visited = new boolean[n];

            int idx = gates[i]-1;
            queue.add(new Edge( idx, 0 ));

            chart[idx] = 0;

            dijkstra(visited);
          /*
            System.out.print("[");
            for(int tmp : chart){
                System.out.print(tmp + ", ");
            }
            System.out.println("]");
            */
        }

        for(int i = 0 ; i<summits.length; i++){
            int summit = summits[i]-1;
            if(chart[summit]<this.cost){
                cost = chart[summit];
                this.idx = summit;
            }else if(chart[summit] == this.cost){
                this.idx = Math.min(this.idx, summit);
            }
        }

        int[] answer = {idx+1, cost};

        return answer;
    }

    public void dijkstra(boolean[] visited){
        while(!queue.isEmpty()){
            Edge edge = queue.poll();

            int cur = edge.visit;
            int cost = edge.cost;

            // System.out.println( (cur+1)+", " + cost);

            if( cost!=chart[cur] || visited[cur] ){ continue; }
            if(!isSummit[cur]){
                visited[cur] = true;
            }

            ArrayList<Edge> nexts = edgeList.get(cur);

            for(int i = 0 ; i<nexts.size(); i++){
                Edge next = nexts.get(i);
                int v = next.visit;
                int c = Math.max(next.cost, cost);
                if( visited[v] || chart[v] <= c ){ continue; }
                chart[v] = c;
                queue.add(new Edge(v, c));
            }
        }
    }
}


/*
10
[[1,10,5],[1,2,1],[2,3,1],[3,4,1],[4,5,1],[5,6,1],[,6,7,1],[7,8,1],[,8,9,1],[9,10,1]]
[1]
[10]
*/
