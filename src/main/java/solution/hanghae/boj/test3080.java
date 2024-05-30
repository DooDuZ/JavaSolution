package solution.hanghae.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class test3080 {

    static int N;
    static String[] names;
    static int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        names = new String[N];

        for (int i = 0; i < N; i++) {
            names[i] = br.readLine();
        }

        Arrays.sort(names);

        System.out.println(countOfSort(0, N, 0));
    }

    private static long countOfSort(int s, int e, int lng) {
        long ret = 1;
        int group = 0;

        boolean checkShort = false;

        for (int i = s; i < e; i++) {
            if (names[i].length() <= lng) {
                s++;
                checkShort = true;
                continue;
            }
            char lastAlp = names[s].charAt(lng);

            if (names[i].charAt(lng) != lastAlp) {
                ret = multiple(ret, countOfSort(s, i, lng + 1));
                s = i;
                group++;
            }

            // 순환이 끝날 때 마지막 그룹에 대한 로직 실행
            if (i + 1 == e) {
                ret = multiple(ret, countOfSort(s, e, lng + 1));
                group++;
            }
        }
        if (checkShort){
            group++;
        }

        ret = multiple(ret, factorial(group));

        return ret;
    }

    private static long factorial(int n) {
        if (n == 1 || n == 0) {
            return 1L;
        }

        return n * factorial(n - 1) % MOD;
    }

    private static long multiple(long a, long b) {
        return a * b % MOD;
    }
}
