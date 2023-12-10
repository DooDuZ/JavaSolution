package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class test1562_top_down {

    static int N;
    static Long[][][] dp;
    static int MOD = 1_000_000_000;
    static int FULL = (1 << 10) - 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new Long[N + 1][10][1 << 10];

        for (int i = 0; i < 10; i++) {
            Arrays.fill(dp[1][i], 0L);
            dp[1][i][FULL] = 1L;
        }
        dp[1][0][FULL] = 0L;

        long answer = 0;

        for (int i = 0; i < 10; i++) {
            answer += count(N, i, 1 << i);
            answer %= MOD;
        }

        System.out.println(answer);
    }

    static long count(int digit, int last, int bit) {
        if (dp[digit][last][bit] == null) {
            long count = 0;

            if (last > 0) {
                count += count(digit - 1, last - 1, bit | (1 << (last - 1)));
            }

            if (last < 9) {
                count += count(digit - 1, last + 1, bit | (1 << (last + 1)));
            }

            dp[digit][last][bit] = count % MOD;
        }

        return dp[digit][last][bit];
    }
}