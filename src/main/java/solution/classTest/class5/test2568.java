package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class test2568 {

    static int N;
    static int[][] arr;
    static int[] dp;
    // 현재 탐색한 인덱스에서 가질 수 있는 최대 LIS값 저장 배열
        // 최대 길이가 idx와 일치하는 경우만 LIS에 포함된다.
    static int[] lng;
    static int idx = 0;

    public static void main(String[] args) {
        try {
            input();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < N; i++) {
            if (arr[i][1] > dp[idx]) {
                idx++;
                dp[idx] = arr[i][1];
                lng[i] = idx;
            } else {
                int l = 0;
                int r = idx;
                int mid;

                while (l < r) {
                    mid = (l + r) / 2;

                    if (dp[mid] < arr[i][1]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }

                dp[r] = arr[i][1];
                lng[i] = r;
            }
        }

        // N에서 남은 줄 수를 차감 = 제거한 줄의 수
        sb.append(N - (idx + 1));

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = lng.length - 1; i >= 0; i--) {
            if(lng[i]==idx){
                idx--;
            }else {
                list.add(arr[i][0]);
            }
        }

        Collections.sort(list);

        for (Integer tmp : list){
            sb.append('\n');
            sb.append(tmp);
        }

        System.out.println(sb);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        dp = new int[N + 1];
        lng = new int[N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = new int[]{a, b};
        }

        Arrays.sort(arr, (e1, e2) -> {
            return e1[0] - e2[0];
        });

        // 출발 값 초기화
        // 안하면 pq에 0 들어감
        dp[0] = arr[0][0];
        dp[0] = arr[0][1];
    }
}

/*
case

4
1 2
2 3
3 4
4 1

answer :
1
4

case
9
1 50000
2 4
3 11
4 12
5 6
6 3
7 2
8 9
9 10

answer
5
1
3
4
6
7

 */