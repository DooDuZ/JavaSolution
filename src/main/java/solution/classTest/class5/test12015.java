package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test12015 {
    static int N;
    static int[] arr;

    // 길이 별 마지막 값의 최대값 저장
    static int[] dp;
    public static void main(String[] args) {
        init();

        int idx = 0;

        for (int i = 1; i < N; i++) {
            if (dp[idx] < arr[i]){
                idx++;
                dp[idx] = arr[i];
            }else {
                int l = 0;
                int r = idx;
                int mid;

                while(l<r){
                    mid = (l+r) / 2;

                    if (dp[mid] < arr[i]){
                        l = mid + 1;
                    }else {
                        r = mid;
                    }
                }

                dp[r] = arr[i];
            }
        }

        System.out.println(idx+1);
    }


    private static void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());

            arr = new int[N];
            dp = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dp[0] = arr[0];

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}