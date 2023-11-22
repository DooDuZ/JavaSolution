package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test14940_bfs {

    static int N;
    static int M;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] result;
    static Queue<Integer[]> queue = new LinkedList<>();

    static boolean[][] visited;

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
                    queue.add(new Integer[]{i, j, 0});
                    result[i][j] = 0;
                } else if (map[i][j] == 0) {
                    result[i][j] = 0;
                }
            }
        }

        bfs();

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

    static void bfs() {
        while (!queue.isEmpty()) {
            Integer[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = cur[0] + dy[i];
                int nextX = cur[1] + dx[i];
                int nextD = cur[2] + 1;

                if (isPossible(nextX, nextY) && result[nextY][nextX] > nextD && map[nextY][nextX] == 1) {
                    visited[nextY][nextX] = true;
                    result[nextY][nextX] = nextD;
                    queue.add(new Integer[]{nextY, nextX, nextD});
                }
            }
        }
    }

    static void dfs(){

    }

    static boolean isPossible(int x, int y) {
        if (x < 0 || x >= M || y < 0 || y >= N) {
            return false;
        }
        return true;
    }
}
