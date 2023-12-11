package solution.levelTest.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1182 {

    static int N;
    static int S;
    static int[] numbers;
    static int answer = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        numbers = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
/*
        for (int i = 1; i < 1 << N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                int bit = 1 << j;
                if ((i & bit) == bit) {
                    sum += numbers[j];
                }
            }
            if (sum == S) {
                answer++;
            }
        }
*/
        dfs(0,0);

        if (S == 0) {
            answer--;
        }

        System.out.println(answer);
    }

    static void dfs(int index, int value) {
        if (index == N) {
            if (value == S) {
                answer++;
            }
            return;
        }

        dfs(index + 1, value);
        dfs(index + 1, value + numbers[index]);
    }
}
