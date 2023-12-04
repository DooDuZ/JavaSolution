package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 비트 마스킹
public class test2098 {

    static int INF = 1_000_000_000;
    static int N;
    static Integer[][] dp;
    static int[][] edges;
    static int fullBit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        fullBit = (1 << N) - 1;

        dp = new Integer[fullBit][N];
        edges = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                edges[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(tsf(1, 0));
    }

    static int tsf(int bit, int v) {
        if (bit == fullBit) {
            if (edges[v][0] != 0) {
                return edges[v][0];
            }
            return INF;
        }

        if (dp[bit][v] != null) {
            return dp[bit][v];
        }

        dp[bit][v] = INF;

        for (int i = 0; i < N; i++) {
            if (edges[v][i] == 0 || (bit & (1 << i)) != 0) {
                continue;
            }

            dp[bit][v] = Math.min(dp[bit][v], tsf(bit | (1 << i), i) + edges[v][i]);
        }

        return dp[bit][v];
    }
}
