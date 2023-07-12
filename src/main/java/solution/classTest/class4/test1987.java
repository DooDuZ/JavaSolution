package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test1987 {
    static int N;
    static int M;
    static int last;
    static char[][] board;
    static boolean[] words = new boolean[26];
    static int answer = 0;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        last = N*M;
        board = new char[N][M];

        for(int i = 0 ; i<N; i++){
            String line = br.readLine();
            for(int j = 0 ; j<M; j++){
                board[i][j] = line.charAt(j);
            }
        }

        words[board[0][0]-65] = true;
        dfs(1,0,0);

        System.out.println(answer);
    }

    public static void dfs(int depth, int row, int col){
        answer = Math.max(depth, answer);

        for(int i = 0; i<4; i++){
            int r = row + dx[i];
            int c = col + dy[i];

            if(r<0 || c<0 || r>=N || c>=M){ continue; }

            char cur = board[r][c];

            if(words[cur-65]){ continue; }

            words[cur-65] = true;
            dfs(depth+1, r, c);
            words[cur-65] = false;
        }
    }
}
