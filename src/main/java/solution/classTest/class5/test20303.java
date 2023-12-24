package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test20303 {

    static int N;
    static int M;
    static int K;
    static Child[] children;
    static ArrayList<Integer[]> groups = new ArrayList<>();

    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        children = new Child[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            children[i] = new Child(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            children[from].friends.add(children[to]);
            children[to].friends.add(children[from]);
        }

        for (Child child : children) {
            if (!child.visited) {
                groups.add(getAllCandies(child));
            }
        }

        Collections.sort(groups, (e1, e2) -> {
            if (e1[0] == e2[0]) {
                return e2[1] - e1[1];
            }
            return e1[0] - e2[0];
        });

        dp = new Integer[K + 1][groups.size() + 1];


    }

    static int knapsack(int weight, int count) {


        return dp[weight][count];
    }

    static Integer[] getAllCandies(Child child) {
        LinkedList<Child> queue = new LinkedList<>();

        int count = 0;
        int candies = 0;

        child.visited = true;
        queue.add(child);

        candies += child.candy;
        count++;

        while (!queue.isEmpty()) {
            Child cur = queue.poll();

            for (Child friend : cur.friends) {
                if (friend.visited) {
                    continue;
                }

                friend.visited = true;
                queue.add(friend);

                candies += friend.candy;
                count++;
            }
        }

        return new Integer[]{count, candies};
    }

    static class Child {
        int candy;
        boolean visited = false;
        ArrayList<Child> friends = new ArrayList<>();

        Child(int candy) {
            this.candy = candy;
        }
    }
}