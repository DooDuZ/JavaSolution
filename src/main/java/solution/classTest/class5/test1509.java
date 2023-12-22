package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class test1509 {

    static Boolean[][] palindrome;
    static char[] sequence;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        sequence = str.toCharArray();

        palindrome = new Boolean[str.length() + 1][str.length() + 1];

        dp = new int[str.length() + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= str.length(); i++) {
            palindrome[i][i] = true;
        }

        for (int i = 1; i < str.length(); i++) {
            if (sequence[i - 1] == sequence[i]) {
                palindrome[i][i + 1] = true;
            } else {
                palindrome[i][i + 1] = false;
            }
        }

        setDp(str.length());

        System.out.println(dp[str.length()]);
    }

    public static int setDp(int end) {
        if (dp[end] == Integer.MAX_VALUE) {
            for (int i = 1; i <= end; i++) {
                if (palin(i, end)) {
                    dp[end] = Math.min(dp[end], setDp(i - 1) + 1);
                }
            }
        }

        return dp[end];
    }

    public static boolean palin(int start, int end) {
        if (palindrome[start][end] == null) {
            if (sequence[start - 1] == sequence[end - 1]) {
                palindrome[start][end] = palin(start + 1, end - 1);
            } else {
                palindrome[start][end] = false;
            }
        }

        return palindrome[start][end];
    }
}
