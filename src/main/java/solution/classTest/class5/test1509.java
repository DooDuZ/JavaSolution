package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1509 {

    static Integer[][] dp;

    static char[] sequence;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        sequence = str.toCharArray();

        dp = new Integer[str.length()][str.length()];

        for (int i = 0; i < str.length(); i++) {
            dp[i][i] = 1;
        }


    }

    static int check(int start, int end) {
        if (dp[start][end] == null) {
            if(sequence[start] == sequence[end]){
                if(end-start == 1 || check(start+1, end-1)==1){
                    return 1;
                }
            }
            return 0;
        }

        return dp[start][end];
    }
}
