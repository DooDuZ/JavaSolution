package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다시 풀기
public class test12015 {

    static int N;
    static int[] numbers;
    static int[] maxValue;
    public static void main(String[] args) {
        init();

        int idx = 0;

        for (int i = 1; i < N; i++) {
            if (maxValue[idx] < numbers[i]){
                idx++;
                maxValue[idx] = numbers[i];
            }else {
                int l = 0;
                int r = idx;
                int mid;

                while(l<r){
                    mid = (l+r) / 2;

                    if (maxValue[mid] < numbers[i]){
                        l = mid + 1;
                    }else {
                        r = mid;
                    }
                }

                maxValue[r] = numbers[i];
            }
        }

        System.out.println(idx+1);
    }


    private static void init() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            N = Integer.parseInt(br.readLine());

            numbers = new int[N];
            maxValue = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            maxValue[0] = numbers[0];

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("입출력 에러");
        }
    }
}

/*
6
20 10 50 10 20 30
 */