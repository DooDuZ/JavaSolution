package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test10942 {

    static int N;
    static int M;
    static Integer[][] dp;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dp = new Integer[N][N];

        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
        }

        for (int i = 0; i < N - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                dp[i][i + 1] = 1;
            }
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()) - 1;

            if (st.hasMoreTokens()) {
                int end = Integer.parseInt(st.nextToken()) - 1;
                sb.append(check(start, end)).append('\n');
            } else {
                sb.append(check(start, start)).append('\n');
            }
        }

        System.out.println(sb);
    }

    static int check(int start, int end) {
        if (dp[start][end] == null) {
            if (numbers[start] == numbers[end]) {
                dp[start][end] = check(start + 1, end - 1);
            } else {
                dp[start][end] = 0;
            }
        }

        return dp[start][end];
    }
}
/*
3
1 1 1
1
1 2

ans : 1

12
1 2 1 3 1 2 1 1 1 1 1 1
10
1 3
2 5
3 3
5 7
5 5
1 7
8 12
8 11
8 10
8 9

 */
