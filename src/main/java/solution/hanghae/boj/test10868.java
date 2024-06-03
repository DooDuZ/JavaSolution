package solution.hanghae.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test10868 {
    static int N, M;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Node node = new Node(0, N - 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            sb.append(node.search(a, b)).append('\n');
        }

        System.out.println(sb);
    }

    static class Node {
        int start, end, min;
        Node parent, left, right;

        Node(int start, int end) {
            this.start = start;
            this.end = end;

            init();
        }

        Node(int start, int end, Node parent) {
            this.start = start;
            this.end = end;
            this.parent = parent;

            init();
        }

        private void init() {
            if (start != end) {
                int mid = (start + end) / 2;

                left = new Node(start, mid, this);

                right = new Node(mid + 1, end, this);

                min = Math.min(left.min, right.min);
            } else {
                this.min = numbers[start];
            }
        }

        public int search(int s, int e) {
            if (s == this.start && e == this.end) {
                return this.min;
            }

            int ret = 1_000_000_001;

            if (s <= left.end) {
                ret = Math.min(left.search(s, Math.min(left.end, e) ), ret);
            }

            if (e >= right.start) {
                ret = Math.min(right.search(Math.max(right.start, s), e), ret);
            }

            return ret;
        }
    }
}

/*
10 1
75
30
100
38
50
51
52
20
81
5
3 5
 */