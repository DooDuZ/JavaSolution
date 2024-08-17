package solution.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test1083 {
    static int N;
    static int S;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        S = Integer.parseInt(br.readLine());


        // 정답 배열 생성
        Integer[] sorted = new Integer[N];

        for (int i = 0; i < N; i++) {
            sorted[i] = numbers[i];
        }

        Arrays.sort(sorted, (e1, e2) -> {
            return e2 - e1;
        });

        // 탐색 시작 인덱스
        int index = 0;

        // 이동 횟수가 남아있고 - index가 범위 안에 있고 - 완전히 정렬이 끝나지 않았다면 반복
        while (S > 0 && index < N && !same(numbers, sorted)) {
            // index + S범위 안에서 가장 큰 수 찾기
            int max = findMax(index);

            // 못찾았다면 시작지점 뒤로 밀고 continue
            if (max == index) {
                index++;
                continue;
            }

            // 찾았다면 값 한칸씩 뒤로 밀고 가져오기
            slide(index, max);

            // 다시 제일 앞부터 탐색 시작
            index = 0;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(numbers[i]).append(" ");
        }

        System.out.println(sb);
    }

    // 뒤로 밀기
    public static void slide(int start, int end){
        int tmp = numbers[end];

        for( int i = end; i > start; i--){
            numbers[i] = numbers[i-1];
        }

        numbers[start] = tmp;
    }

    // 가용 가능 범위 내의 큰 수 찾기
    public static int findMax(int start) {
        int max = start;

        int end = start + S + 1;

        if (end > N) {
            end = N;
        }

        for (int i = start; i < end; i++) {
            if (numbers[max] < numbers[i]) {
                max = i;
            }
        }

        // 이동한 횟수만큼 차감
        S -= (max - start);

        return max;
    }

    // 배열 비교 메서드
    public static boolean same(int[] arr, Integer[] arr2) {
        for (int i = 0; i < N; i++) {
            if (arr[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}


/*
5
19 17 18 15 20
5


 */