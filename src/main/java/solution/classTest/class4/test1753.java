package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 다시 풀기
public class test1753 {
    static boolean[] visited;
    static int[] dist;
    static ArrayList<GraphNode> nodeList = new ArrayList<>();
    static PriorityQueue<Integer> queue = new PriorityQueue<>( (e1,e2)->{
        return dist[e1] - dist[e2];
    } );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        dist = new int[N];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0 ; i<N; i++){
            nodeList.add(new GraphNode(i));
        }

        int startIdx = Integer.parseInt(br.readLine())-1;

        for(int i = 0 ; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int distance = Integer.parseInt(st.nextToken());

            nodeList.get(from).linked.add( new Integer[]{to, distance} );
        }

        dist[startIdx] = 0;
        queue.add(startIdx);
        setDist();

        for(int i = 0 ; i<N; i++){
            if(dist[i]==Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            }else{
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void setDist(){
        while (!queue.isEmpty()){
            GraphNode currentNode = nodeList.get(queue.poll());
            int currentIdx = currentNode.idx;
            if(visited[currentIdx]){
                continue;
            }
            visited[currentIdx] = true;

            for(Integer[] arr : currentNode.linked){
                int idx = arr[0];
                int weight = arr[1];
                dist[idx] = Math.min( dist[currentNode.idx] + weight, dist[idx] );
                queue.add(idx);
            }
        }
    }
}

class GraphNode{
    int idx;
    ArrayList<Integer[]> linked = new ArrayList<>();
    GraphNode(int idx){
        this.idx = idx;
    }
}

/*
4 3
1
1 2 10
2 3 10
3 4 10

answer
0
10
20
30

------------------------------------------------

입력

2 1
1
1 2 2

정답

0
2

------------------------------------------------

입력

10 9
1
1 2 9
2 8 9
7 3 10
5 6 6
3 4 7
4 5 2
6 10 8
8 5 4
2 3 10

정답

0
9
19
26
22
28
INF
18
INF
36

4 4
1
1 2 10
1 3 1
3 2 1
2 4 1

2 3
1
1 2 3
1 2 1
1 2 4


5 7
1
5 1 1
1 2 2
1 3 3
1 4 10
2 3 4
2 4 5
3 4 6

3 2
3
1 3 10
2 1 4

정답

INF
INF
0


2 1
2
2 1 1

정답
1
0

4 8
1
1 2 3
2 1 5
4 3 4
2 3 10
1 3 10
2 4 1
3 1 1
1 2 2

정답
0
2
7
3

===================

2 4
1
1 2 1
1 2 2
1 2 5
1 2 10

정답

0
1

===================

2 3
2
1 2 1
1 2 1
1 2 1

정답
INF
0

===================

3 3
2
2 1 4
2 1 4
2 1 4
정답
4
0
INF

===================

5 8
2
1 2 3
2 1 5
4 3 4
2 3 10
1 3 10
2 4 1
3 1 1
1 2 2

정답

5
0
5
1
INF

===================

4 6
2
3 1 2
1 4 2
4 3 2
3 4 2
2 3 2
2 4 2

정답

4
0
2
2

===================

3 4
2
1 3 5
2 1 9
2 3 3
2 1 10

정답

9
0
3

===================

12 20
1
1 2 1
1 3 1
1 4 2
1 5 2
1 6 2
1 7 2
1 8 2
1 9 3
1 10 4
1 11 5
2 11 5
3 11 4
4 11 3
5 11 2
6 11 1
7 10 1
8 10 2
9 10 3
10 11 4
1 11 10
정답
0
1
1
2
2
2
2
2
3
3
3
INF

 */