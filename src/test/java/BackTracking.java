import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BackTracking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        comb = new int[m];

        dfs(1, 0);

        System.out.println(sb);
    }

    static int n;
    static int m;
    static int[] comb;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth, int idx) {
        if (depth == m) {
            for (int tmp : comb) {
                sb.append(tmp).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i <= n; i++) {
            comb[depth] = i;
            dfs(depth + 1, i+1);
        }
    }
}
