package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test10775 {

    static int G;
    static int P;
    static boolean[] gates;
    static int[] indexes;
    static int[] requests;

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());

        P = Integer.parseInt(br.readLine());

        gates = new boolean[G + 1];
        indexes = new int[G + 1];
        requests = new int[P];

        for (int i = 0; i < P; i++) {
            requests[i] = Integer.parseInt(br.readLine());
        }

        // 주어지지 않은 게이트 사용 처리
        for (int i = P+1; i <= G; i++) {
            gates[i] = true;
        }

        // 인덱싱
        for (int i = 1; i <= G; i++) {
            indexes[i] = i;
        }

        for (int plane : requests){
            if(docking(plane)){
                answer++;
            }else {
                break;
            }
        }

        System.out.println(answer);
    }

    static boolean docking(int plane) {
        int index = indexes[plane];

        while (index > 0 && gates[index]) {
            index--;
        }

        // 도킹 가능 게이트 없음
        if (index <= 0) {
            return false;
        }

        gates[index] = true;
        indexes[plane] = --index;

        return true;
    }
}
