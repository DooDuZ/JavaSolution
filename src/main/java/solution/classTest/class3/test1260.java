package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test1260 {
    static ArrayList<Node> list = new ArrayList<>();
    static LinkedList<Node> queue = new LinkedList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        visited = new boolean[N];

        for(int i = 1 ; i<=N; i++){
            list.add(new Node(i));
        }

        for(int i = 0 ; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            list.get(parent-1).nodeList.add(list.get(child-1));
            list.get(child-1).nodeList.add(list.get(parent-1));
        }

        queue.add(list.get(start-1));
        dfs(list.get(start-1));
        sb.append("\n");
        visited = new boolean[N];
        bfs();
        System.out.println(sb);
    }

    public static void dfs(Node node){
        sb.append(node.Index).append(" ");
        visited[node.Index-1] = true;

        Collections.sort(node.nodeList, (e1, e2)->{
            return e1.Index-e2.Index;
        });

        if(node.nodeList.size()==0){
            return;
        }
        for(int i=0; i<node.nodeList.size(); i++){
            if(visited[node.nodeList.get(i).Index-1]){ continue; }
            dfs(node.nodeList.get(i));
        }
    }

    public static void bfs(){
        if(queue.size()==0){
            return;
        }
        Node node = queue.pop();

        Collections.sort(node.nodeList, (e1, e2)->{
            return e1.Index-e2.Index;
        });

        sb.append(node.Index).append(" ");
        visited[node.Index-1] = true;

        for(int i = 0; i<node.nodeList.size(); i++){
            if(visited[node.nodeList.get(i).Index-1]){ continue; }
            queue.add(node.nodeList.get(i));
            visited[node.nodeList.get(i).Index-1] = true;
        }
        bfs();
    }
}
class Node {
    int Index;
    ArrayList<Node> nodeList = new ArrayList<>();
    public Node(int Index){
        this.Index = Index;
    }
}