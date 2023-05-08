package solution.woowahan;

public class PathCount {

    // dp[row][col][0] = 대각선 이동 전
    // dp[row][col][1] = 대각선 이동 후
    static Integer[][][] dp;
    static int[][] diagonalMap;
    static int max = 0;

    // 실제 문제와 다른 점
        // 문제는 1-indexed - 내가 구현한건 0-indexed
        // 문제는 x,y 좌표 - 나는 i,j 좌표 (행열 순서 반대)
        // 대각선 좌표는 문제와 동일하게 받도록 설정해놓고 가로/세로 길이는 0-indexed 기준으로 받고있엇음... n/m에 1씩 더하니 답이 바르게 나옴
    public static void main(String[] args) {
        int n = 38;
        int m = 52;
        diagonalMap = new int[n][m];
        int[][] param = { {19,17} };

        for(int i = 0 ; i<param.length; i++){
            setDiagonal(param[i][0], param[i][1]);
        }

        max = n+m+1;
        dp = new Integer[n][m][2];
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;
        for(int i = 0 ; i<n; i++){
            dp[i][0][1] = 1;
        }
        for(int i = 0 ; i<m; i++){
            dp[0][i][1] = 1;
        }
        for(int i = 0 ; i<n; i++){
            for(int j = 0 ; j<m; j++){
                if(diagonalMap[i][j]!=0){
                    dp[i][j][0] = 0;
                }
            }
        }
        recur(n-1,m-1,1);

        for(int i = 0 ; i<n; i++){
            for(int j = 0 ; j<m; j++){
                if(diagonalMap[i][j]==1){
                    dp[i][j][0] = dp[i+1][j-1][1];
                }else if(diagonalMap[i][j]==2){
                    dp[i][j][0] = dp[i-1][j+1][1];
                }else if(diagonalMap[i][j]==3){
                    dp[i][j][0] = (dp[i-1][j+1][1] + dp[i+1][j-1][1]) % 10000019 ;
                }
            }
        }

        long answer = 0L;

        for(int i = 0 ; i<n; i++){
            for(int j = 0 ; j<m; j++){
                if( diagonalMap[i][j]>0 ){
                    answer += ((long)dp[n-1-i][m-1-j][1]*(long)dp[i][j][0])%10000019;
                    answer %= 10000019;
                }
            }
        }

        System.out.println(answer);
    }

    public static void setDiagonal(int row, int col){
        if(diagonalMap[row-1][col]==0){
            diagonalMap[row-1][col] = 1; // 하단
        }else{
            diagonalMap[row-1][col] = 3; // 상하단 둘다 포함
        }

        if(diagonalMap[row][col-1]==0){
            diagonalMap[row][col-1] = 2; // 상단
        }else {
            diagonalMap[row][col-1] = 3; // 상하단 둘다 포함
        }
    }

    public static int recur(int row, int col, int isDiagonal){
        if(dp[row][col][isDiagonal] == null){
            dp[row][col][isDiagonal] = ( recur(row - 1, col, isDiagonal) + recur(row, col - 1, isDiagonal) )%10000019;
        }
        return dp[row][col][isDiagonal];
    }
}
