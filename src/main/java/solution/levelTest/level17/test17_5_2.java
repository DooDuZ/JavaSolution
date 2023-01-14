package solution.levelTest.level17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test17_5_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st =new StringTokenizer(br.readLine());

        arr[0] = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            arr[i] = Math.max(arr[i-1]+n, n);
        }

        Arrays.sort(arr);

        System.out.println(arr[N-1]);
    }
}
