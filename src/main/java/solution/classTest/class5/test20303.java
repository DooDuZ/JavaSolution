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

    static int[] dp;

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

        dp = new int[K+1];

        knapsack();

        System.out.println(dp[K-1]);
    }

    static void knapsack() {

        for (int i = 0; i < groups.size(); i++) {

            Integer[] group = groups.get(i);

            for (int j = K; j - group[0] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - group[0]] + group[1]);
            }
        }
    }

/*
    top-down 시간 초과

    static int knapsack(int index, int weight) {
        if (index < 0) {
            return 0;
        }

        if (dp[index][weight] == null) {

            Integer[] group = groups.get(index);

            if (group[0] > weight) {
                dp[index][weight] = knapsack(index - 1, weight);
            } else {
                dp[index][weight] = Math.max(knapsack(index - 1, weight),
                        knapsack(index - 1, weight - group[0]) + group[1]);
            }
        }

        return dp[index][weight];
    }

 */

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