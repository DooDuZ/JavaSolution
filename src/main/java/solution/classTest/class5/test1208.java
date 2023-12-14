package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class test1208 {

    static int N;
    static int S;
    static int[] sequence;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        sequence = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        dfs(0, 0, N / 2, left);
        dfs(N / 2, 0, N, right);

        Collections.sort(left);
        Collections.sort(right, Collections.reverseOrder());

        twoPointer(left.toArray(new Integer[0]), right.toArray(new Integer[0]));

        if (S == 0) {
            answer--;
        }

        System.out.println(answer);
    }

    static void twoPointer(Integer[] left, Integer[] right) {
        int start = 0;
        int end = 0;

        while (start < left.length && end < right.length) {
            int sum = left[start] + right[end];

            if (sum == S) {
                int countL = 0;
                int l = left[start];

                while (start < left.length && left[start] == l) {
                    countL++;
                    start++;
                }

                int countR = 0;
                int r = right[end];

                while (end < right.length && right[end] == r) {
                    countR++;
                    end++;
                }

                answer += (long) countL * countR;

            } else if (sum < S) {
                start++;
            } else {
                end++;
            }
        }
    }

    static void dfs(int index, int value, int end, ArrayList<Integer> sum) {
        if (index == end) {
            sum.add(value);
            return;
        }

        dfs(index + 1, value, end, sum);
        dfs(index + 1, value + sequence[index], end, sum);
    }
}