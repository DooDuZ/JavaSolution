package solution.levelTest.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(calculate(A, B, C));
    }

    public static long calculate(int A, int B,int C){
        if(B==1){
            return A % C;
        }

        long tmp = calculate(A, B/2, C);

        if(B%2==1){
            return ((tmp*tmp%C) * A%C) % C ;
        }

        return (tmp*tmp) % C;
    }
}
