package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class test14003 {
    static int N;
    static int[] numbers;
    static int[] dp;
    static int[] indexes;
    static int MIN = -100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        dp = new int[N + 1];
        indexes = new int[N];

        // 안하면 음수 값 들어올 때 이상하게 돈다
        Arrays.fill(dp, MIN);

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int lng = 0;
        for (int i = 0; i < N; i++) {
            if (numbers[i] > dp[lng]) {
                lng++;
                dp[lng] = numbers[i];
                indexes[i] = lng;
            } else {
                int idx = binarySearch(0, lng, numbers[i]);
                dp[idx] = numbers[i];
                indexes[i] = idx;
            }
        }

        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> subset = new ArrayList<>();
        for (int i = N-1; i >= 0; i--) {
            if ( indexes[i] == lng ){
                subset.add(numbers[i]);
                lng--;
            }
        }

        Collections.sort(subset);

        // 현재 길이 추가
        sb.append(subset.size()).append('\n');

        for (Integer tmp : subset){
            sb.append(tmp).append(' ');
        }

        System.out.println(sb);
    }

    private static int binarySearch(int l, int r, int value) {
        if (l == r) {
            return r;
        }

        int mid = (l + r) / 2;

        if (dp[mid] < value) {
            l = mid + 1;
        } else {
            r = mid;
        }

        return binarySearch(l, r, value);
    }
}