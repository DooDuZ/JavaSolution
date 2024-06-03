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

        // 루트 노드용 생성자
        Node(int start, int end) {
            this.start = start;
            this.end = end;

            init();
        }

        // 배열 범위를 생성자 파라미터로 입력 받습니다.
        Node(int start, int end, Node parent) {
            this.start = start;
            this.end = end;
            this.parent = parent;

            // 세팅 시작
            init();
        }

        // 범위를 기준으로 좌/우로 나눠 노드를 생성해 left, right에 넣어줍니다.
        // 범위가 최소 단위라면, 배열 값을 min으로 지정해줍니다.
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

        // 범위를 기준으로 탐색합니다.
        public int search(int s, int e) {
            // 범위가 완전히 일치하면 최소값 return
            if (s == this.start && e == this.end) {
                return this.min;
            }

            int ret = 1_000_000_001;

            // 시작점이 왼쪽 노드의 끝점보다 작거나 같다면 왼쪽 노드의 끝점/현재 탐색지점의 끝 점중 작은 값을 범위로 넘겨줍니다.
            if (s <= left.end) {
                ret = Math.min(left.search(s, Math.min(left.end, e) ), ret);
            }

            // 끝 점이 오른쪽 노드의 시작점보다 크거나 같다면 현재 시작점과 오른쪽 노드의 시작점 중 큰 값을 시작 지점으로 넘겨줍니다.
            if (e >= right.start) {
                ret = Math.min(right.search(Math.max(right.start, s), e), ret);
            }

            return ret;
        }
    }
}