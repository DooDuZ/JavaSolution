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

        // 길이가 짧아 비교가 불가능한 그룹이 있는지 체크
        boolean checkShort = false;

        for (int i = s; i < e; i++) {
            // 탐색하는 문자의 길이가 조건보다 짧다면 체크하고 인덱스를 다음으로 넘겨준다.
            if (names[i].length() <= lng) {
                s++;
                checkShort = true;
                continue;
            }

            // 현재 탐색해야할 문자
            char lastAlp = names[s].charAt(lng);

            // 탐색하는 문자와 현재 문자열의 해당 위치 문자가 다른 경우
            if (names[i].charAt(lng) != lastAlp) {
                // 시작 인덱스부터 현재 진행 중인 인덱스 전까지 탐색하도록 넘겨주고
                ret = multiple(ret, countOfSort(s, i, lng + 1));
                // 시작점을 현재로 당겨온다
                s = i;
                // 단어 그룹 증가
                group++;
            }

            // 순환이 끝날 때 마지막 그룹에 대한 로직 실행
            if (i + 1 == e) {
                ret = multiple(ret, countOfSort(s, e, lng + 1));
                group++;
            }
        }

        // 짧은 단어 그룹이 있다면 그룹 하나 증가
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
