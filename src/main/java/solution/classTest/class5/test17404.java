package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test17404 {
    static int N;
    static int[][] costs;
    static Integer[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        costs = new int[N][3];
        dp = new Integer[N][3][3];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            costs[i][0] = Integer.parseInt(st.nextToken());
            costs[i][1] = Integer.parseInt(st.nextToken());
            costs[i][2] = Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.min(paint(N - 1, 0, 0), Math.min(paint(N - 1, 1, 1), paint(N - 1, 2, 2))));
    }

    static int paint(int n, int color, int last) {
        if (n == 0) {

            if(color == last){
                return 1000000;
            }

            return costs[n][color];
        }

        if (dp[n][color][last] == null) {

            PriorityQueue<Integer> pq = new PriorityQueue();

            for (int i = 0; i < 3; i++) {
                if (i == color) {
                    continue;
                }

                pq.add(paint(n - 1, i, last));
            }

            dp[n][color][last] = pq.poll() + costs[n][color];
        }

        return dp[n][color][last];
    }
}

/*
3
10 50 50
15 15 15
10 50 50

정답: 75



3
13 89 99
49 60 57
26 40 83

정답: 110



2

1000 1000 1

1000 1000 1

정답: 1001
 */