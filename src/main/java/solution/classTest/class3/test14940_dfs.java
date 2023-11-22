package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// dfs는 시간초과 남
    // bfs로 통과했지만, 연습 겸 dfs로 바꿔봄
public class test14940_dfs {

    static int N;
    static int M;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] result;
    static boolean[][] visited;

    static int[] start = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        result = new int[N][M];

        visited = new boolean[N][M];

        for (int[] arr : result) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    visited[i][j] = true;
                    start[0] = i;
                    start[1] = j;
                    result[i][j] = 0;
                } else if (map[i][j] == 0) {
                    result[i][j] = 0;
                }
            }
        }

        dfs(start[0], start[1], 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    result[i][j] = -1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int y, int x, int distance) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (isPossible(nextX, nextY) && result[nextY][nextX] > distance + 1) {
                result[nextY][nextX] = distance + 1;
                visited[nextY][nextX] = true;
                dfs(nextY, nextX, distance + 1);
            }
        }
    }

    static boolean isPossible(int x, int y) {
        if (x < 0 || x >= M || y < 0 || y >= N) {
            return false;
        }
        return true;
    }
}
/*
10 15
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 2 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
1 1 1 1 1 1 1 1 1 1 0 1 0 0 0

 */