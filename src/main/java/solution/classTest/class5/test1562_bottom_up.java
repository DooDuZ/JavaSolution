package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1562_bottom_up {

    static int N;
    static long[][][] dp;
    static int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new long[N + 1][10][1 << 10];

        for (int i = 1; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 1 << 10; k++) {
                    int bit = (1 << j) | k;

                    long count = 0;
                    if (j > 0) {
                        count += dp[i - 1][j - 1][k];
                    }

                    if (j < 9) {
                        count += dp[i - 1][j + 1][k];
                    }

                    dp[i][j][bit] = (dp[i][j][bit] + count) % MOD;
                }
            }
        }

        long answer = 0;

        for (int i = 0; i < 10; i++) {
            answer += dp[N][i][1023];
            answer %= MOD;
        }

        System.out.println(answer);
    }
}
