package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class test2143 {
    static int T, n, m;
    static int[] A, B;
    static Map<Integer, Integer> caseA = new HashMap<>();
    static Map<Integer, Integer> caseB = new HashMap<>();

    public static void main(String[] args) throws IOException {

        input();
        setCases();

        long cnt = 0;

        for (Integer n : caseA.keySet()){
            if (caseB.containsKey(T-n)){
                cnt += (long)caseB.get(T-n) * caseA.get(n);
            }
        }

        System.out.println(cnt);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());


        A = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        A[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken()) + A[i - 1];
        }

        m = Integer.parseInt(br.readLine());
        B = new int[m];

        st = new StringTokenizer(br.readLine());

        B[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken()) + B[i - 1];
        }

        br.close();
    }

    static void setCases() {

        //A의 모든 부분 수열의 합 얻기
        for (int tmp : A){
            caseA.put(tmp, caseA.getOrDefault(tmp, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int key = A[j] - A[i];
                caseA.put(key, caseA.getOrDefault(key, 0) + 1);
            }
        }

        //B의 모든 부분 수열의 합 얻기
        for (int tmp : B){
            caseB.put(tmp, caseB.getOrDefault(tmp, 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int key = B[j] - B[i];
                caseB.put(key, caseB.getOrDefault(key, 0) + 1);
            }
        }
    }
}
