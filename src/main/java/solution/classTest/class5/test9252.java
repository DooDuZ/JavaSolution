package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class test9252 {
    static String first;
    static String second;
    static int[][] dp;
    static Stack<Character> pattern = new Stack<>();

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        first = br.readLine();
        second = br.readLine();

        n = first.length();
        m = second.length();

        dp = new int[n + 1][m + 1];

        lcs();
        getPattern(n, m);

        StringBuilder sb = new StringBuilder();

        while (!pattern.isEmpty()) {
            sb.append(pattern.pop());
        }

        System.out.println(dp[n][m]);
        System.out.println(sb);
    }

    static void getPattern(int r, int c) {
        while (r > 0 && c > 0) {
            if (dp[r][c] == dp[r - 1][c]) {
                r--;
            } else if (dp[r][c] == dp[r][c - 1]) {
                c--;
            } else {
                pattern.add(first.charAt(r-1));
                r--;
                c--;
            }
        }
    }

    static void lcs() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }
}
