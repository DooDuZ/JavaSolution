package solution.hanghae.boj.daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class test1135 {

    static int N;
    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tree = new Node[N];

        // 노드 생성
        for (int i = 0; i < N; i++) {
            tree[i] = new Node(i);
        }

        // 자식 노드 입력하기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                continue;
            }

            tree[parent].children.add(tree[i]);
            tree[i].parent = tree[parent];
        }

        System.out.println(dfs(0) - 1);
    }

    private static int dfs(int v){
        Node node = tree[v];
        List<Node> children = node.children;
        int size = children.size();
        if (size == 0){
            return 1;
        }

        Integer[] times = new Integer[size];

        for (int i = 0 ; i< size; i++){
            times[i] = dfs(children.get(i).v);
        }

        Arrays.sort(times, Collections.reverseOrder());

        for (int i = 0; i < size; i++){
            times[i] += i;
        }

        Arrays.sort(times, Collections.reverseOrder());

        return times[0] + 1;
    }

    static class Node {
        int v;
        Node parent;
        List<Node> children = new ArrayList<>();

        Node(int v) {
            this.v = v;
        }
    }
}

/*
10
-1 0 0 1 2 2 2 3 7 2

23
-1 0 1 1 1 2 2 2 3 3 3 4 4 4 0 14 15 16 17 18 19 20 21

28
-1 0 1 1 1 2 2 2 3 3 3 4 4 4 0 14 15 16 17 18 19 20 21 4 4 4 4 4

34
-1 0 1 1 1 2 2 2 3 3 3 4 4 4 0 14 15 16 17 18 19 20 21 4 4 4 4 4 19 19 19 19 19 19

15
-1 0 0 0 0 2 2 3 3 6 7 7 4 12 13
 */