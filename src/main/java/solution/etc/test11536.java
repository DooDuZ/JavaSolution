package solution.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test11536 {

    static int N;
    static String NEITHER = "NEITHER";
    static String ASC = "DECREASING";
    static String DESC = "INCREASING";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String[] names = new String[N];

        for (int i = 0; i < N; i++) {
            names[i] = br.readLine();
        }

        boolean prev = names[0].compareTo(names[1]) >= 0;

        for (int i = 1; i < N - 1; i++) {
            if (prev != names[i].compareTo(names[i + 1]) >= 0) {
                System.out.println(NEITHER);
                System.exit(0);
            }
        }

        if (prev) {
            System.out.println(ASC);
        } else {
            System.out.println(DESC);
        }
    }
}
