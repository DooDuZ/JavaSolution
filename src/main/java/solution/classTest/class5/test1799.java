package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간초과 발생
    // dfs 색상 조건 추가
public class test1799 {
    static int N;
    static int[][] board;
    static boolean[][] inserted;
    static boolean[][] colors;
    static int max = 0;
    static int max2 = 0;

    // 아래쪽은 착수 전이므로 검사할 필요 x, 윗방향 대각선만 체크
    static int[] dx = { -1, -1 };
    static int[] dy = { -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        colors = new boolean[N][N];
        inserted = new boolean[N][N];

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                colors[i][j] = ( (i%2==0 && j%2==0) || (i%2==1 && j%2==1) ) ? true : false;
            }
        }

        dfs(0,0,0, true);
        dfs(0,0,0, false);

        System.out.println(max+max2);
    }

    public static void dfs(int row, int col, int value, boolean color){
        if(col==N){
            col = 0;
            row++;
        }

        if(row>=N){
            if(color){
                max = Math.max(value, max);
            }else{
                max2 = Math.max(value, max2);
            }

            return;
        }

        // 놓을 수 있다면 놓는다
        if( colors[row][col]==color && isPossible(row,col)){
            inserted[row][col] = true;
            dfs(row, col+1, value+1, color);
            inserted[row][col] = false;
        }

        // 착수 가능 여부 상관 없이 놓지 않고 지나간다
        dfs(row, col+1, value, color);
    }

    public static boolean isPossible(int row, int col){
        if(board[row][col]==0 ){
            return false;
        }
        return findBishop(row,col);
    }
    public static boolean findBishop(int row, int col){
        for(int i = 0 ; i<2; i++){
            int dr = dx[i];
            int dc = dy[i];

            int r = row;
            int c = col;

            while(true){
                r += dr;
                c += dc;
                if(r<0 || r>=N || c<0 || c>=N){
                    break;
                }
                if(inserted[r][c]){
                    return false;
                }
            }
        }
        /*for(int i = 0 ; i < N; i++) {
            for(int j = 0 ; j<N; j++) {
                if(row+col != i+j && Math.abs(row-col) != Math.abs(i-j)){
                    continue;
                }
                if(inserted[row][col]){
                    return false;
                }
            }
        }*/
        return true;
    }
}