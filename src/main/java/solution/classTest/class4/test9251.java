package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test9251 {
    static String first;
    static String second;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        first = br.readLine();
        second = br.readLine();

        dp = new Integer[first.length()][second.length()];

        int count = lcs(first.length() - 1, second.length() - 1);

        System.out.println(count);
    }

    static int lcs(int r, int c) {
        if (r < 0 || c < 0) {
            return 0;
        }

        if (dp[r][c] == null) {
            if (first.charAt(r) == second.charAt(c)) {
                dp[r][c] = lcs(r - 1, c - 1) + 1;
            } else {
                dp[r][c] = Math.max(lcs(r - 1, c), lcs(r, c - 1) );
            }
        }

        return dp[r][c];
    }
}
