package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class test1967 {
    // test1167의 treeNode 사용
    static ArrayList<TreeNode> nodeList = new ArrayList<>();
    static boolean[] visited;

    static int maximum = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N];

        for(int i = 0 ; i<N; i++){
            nodeList.add(new TreeNode(i));
        }

        for(int i=0 ; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int distance = Integer.parseInt(st.nextToken());
            TreeNode startNode = nodeList.get(from);
            TreeNode endNode = nodeList.get(to);

            startNode.linked.add(new Integer[]{ to, distance });
            endNode.linked.add(new Integer[]{ from, distance });
        }

        for(int i = 0 ; i<nodeList.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(0, nodeList.get(i));
                visited[i] = false;
            }
        }

        System.out.println(maximum);
    }

    public static void dfs(int distance, TreeNode currentNode){
        boolean isLast = true;
        for(int i = 0 ; i<currentNode.linked.size(); i++){
            Integer[] arr =  currentNode.linked.get(i);
            if( !visited[arr[0]] ){
                isLast = false;
                visited[arr[0]] = true;
                TreeNode node = nodeList.get(arr[0]);
                dfs(distance + arr[1], node);
                visited[arr[0]] = false;
            }
        }
        if (isLast){
            maximum = Math.max(maximum, distance);
        }
    }
}