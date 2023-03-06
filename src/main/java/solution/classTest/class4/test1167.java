package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 모든 정점을 순회할 경우 시간초과
    // 1. 임의의 한 노드에서 가장 먼 노드 찾기
    // 2. 해당 노드에서 가장 먼 노드까지의 거리 = 트리의 지름
public class test1167 {
    static ArrayList<TreeNode> nodeList = new ArrayList<>();
    static boolean[] visited;
    static int maximum = Integer.MIN_VALUE;
    static int endNode = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N];

        for(int i = 0 ; i<N; i++){
            nodeList.add(new TreeNode(i));
        }

        for(int i=0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            while (true){
                int to = Integer.parseInt(st.nextToken())-1;
                if(to==-2){ break; }
                int distance = Integer.parseInt(st.nextToken());
                TreeNode startNode = nodeList.get(from);
                TreeNode endNode = nodeList.get(to);

                startNode.linked.add(new Integer[]{ to, distance });
                endNode.linked.add(new Integer[]{ from, distance });
                /*
                    map->ArrayList로 내부 저장 자료구조 변경
                    map이 되려 탐색에 시간이 더 걸릴듯

                    startNode.linked.put(endNode, distance);
                    endNode.linked.put(startNode, distance);
                */
            }
        }

        Collections.sort(nodeList, (e1,e2)->{
            return e1.idx - e2.idx;
        });

        // System.out.println(nodeList.toString());

        // System.out.println("시작노드는 " + endNode);
        visited[endNode] = true;
        dfs(0, nodeList.get(endNode));

        Arrays.fill(visited, false);

        // System.out.println(maximum);

        // System.out.println("시작노드는 " + endNode);
        visited[endNode] = true;
        dfs(0, nodeList.get(endNode));

        System.out.println(maximum);
    }

    public static void dfs(int distance, TreeNode currentNode){

        // System.out.println("방문 노드는 " + currentNode.idx);

        boolean isLast = true;
        for(int i = 0 ; i<currentNode.linked.size(); i++){
            Integer[] arr = currentNode.linked.get(i);
            if(!visited[arr[0]]){
                isLast = false;
                visited[arr[0]] = true;
                dfs( distance+arr[1], nodeList.get(arr[0]) );
            }
        }
        if(isLast && maximum<distance){
            endNode = currentNode.idx;
            maximum = distance;
        }
    }
}

class TreeNode{
    int idx;
    // Map<TreeNode, Integer> linked = new HashMap<>();
    ArrayList<Integer[]> linked = new ArrayList<>();
    TreeNode(int idx){
        this.idx = idx;
    }

    @Override
    public String toString(){
        return String.valueOf(idx);
    }
}

/*
5
4 2 4 3 3 5 6 -1
1 3 2 -1
2 4 4 -1
5 4 6 -1
3 1 2 4 3 -1

4
1 2 5 3 9 -1
2 1 5 -1
3 1 9 4 8 -1
4 3 8 -1

답 : 22

6
1 2 3 -1
2 1 3 5 3 3 5 -1
3 2 5 4 7 -1
4 3 7 -1
5 2 3 6 5 -1
6 5 5 -1

답 : 20

4
1 2 7 3 2 -1
2 1 7 -1
3 1 2 4 3 -1
4 3 3 -1

답 : 12

5
1 2 7 3 2 5 10 -1
2 1 7 -1
3 1 2 4 3 -1
4 3 3 -1
5 1 10 -1

답 : 17
 */