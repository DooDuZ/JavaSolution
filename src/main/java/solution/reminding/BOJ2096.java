// BOJ 2096 내려가기 https://www.acmicpc.net/problem/2096
// solved.ac class 4

package solution.reminding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2096 {

    static int[][] cells;
    static int[][] dp;
    static int N;
    static int INF = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        cells = new int[N][3];
        dp = new int[N][3];

        StringTokenizer st;

        for (int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j = 0 ; j < 3 ; j++){
                cells[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sb.append(getCost(1)).append(' ');
        sb.append(getCost(-1));

        System.out.println(sb.toString());
    }

    private static int getCost(int direction){
        Integer[] result = new Integer[3];

        // 각 시작점 세팅
        initDp();
        result[0] = setDp(direction, 0 ,0);
        initDp();
        result[1] = setDp(direction, 0, 1);
        initDp();
        result[2] = setDp(direction, 0, 2);

        Arrays.sort(result, (e1,e2) -> {
            return e2 * direction - e1 * direction;
        });
        return result[0];
    }

    private static int setDp(int direction, int row, int col){
        if (dp[row][col] == -1){
            dp[row][col] = cells[row][col];
            int target = INF * direction * -1;

            boolean flag = false;

            for (int i = -1; i <=1; i++){
                int nr = row + 1;
                int nc = col + i;
                if (isPossible(nr, nc)){
                    flag = true;
                    if (direction == 1){
                        target = Math.max(target, setDp(direction, nr, nc));
                    }else{
                        target = Math.min(target, setDp(direction, nr, nc));
                    }

                }
            }

            if (flag){
                dp[row][col] += target;
            }
        }

        return dp[row][col];
    }

    private static void initDp(){
        for (int i = 0 ; i < N; i++){
            Arrays.fill(dp[i], -1);
        }
    }

    private static boolean isPossible(int row, int col){
        if (row >= 0 && row < N && col >= 0 && col < 3){
            return true;
        }

        return false;
    }
}

/*
3
1 0 0
0 1 0
0 0 1

 */