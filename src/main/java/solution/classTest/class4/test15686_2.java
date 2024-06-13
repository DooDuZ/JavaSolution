package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test15686_2 {

    static int N;
    static int M;
    static int[][] city;
    static int answer = Integer.MAX_VALUE;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static ArrayList<Integer[]> houses = new ArrayList<>();
    static ArrayList<Integer[]> shops = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int data = Integer.parseInt(st.nextToken());
                if (data == 1) {
                    city[i][j] = data;
                    houses.add(new Integer[]{i, j});
                } else if (data == 2) {
                    shops.add(new Integer[]{i, j});
                }
            }
        }

        boolean[] visited = new boolean[shops.size()];
        dfs(0, 0, visited);

        System.out.println(answer);
    }

    static void dfs(int depth, int idx, boolean[] selected) {
        if (depth == M) {
            int[][] chart = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(chart[i], Integer.MAX_VALUE);
            }
            for (int i = 0; i < shops.size(); i++) {
                if (selected[i]) {
                    bfs(shops.get(i), chart);
                }
            }
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (city[i][j] == 1){
                        sum += chart[i][j];
                    }
                }
            }

            answer = Math.min(answer, sum);

            return;
        }

        for (int i = idx; i < shops.size(); i++) {
            if (!selected[i]) {
                selected[i] = true;
                Integer[] coords = shops.get(i);
                city[coords[0]][coords[1]] = 2;
                dfs(depth + 1, i, selected);
                city[coords[0]][coords[1]] = 0;
                selected[i] = false;
            }
        }
    }

    static void bfs(Integer[] shop, int[][] chart) {
        LinkedList<Integer[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        queue.add(new Integer[]{shop[0], shop[1], 0});
        visited[shop[0]][shop[1]] = true;

        while (!queue.isEmpty()) {
            Integer[] cur = queue.poll();

            if (city[cur[0]][cur[1]] == 1 && chart[cur[0]][cur[1]] > cur[2]) {
                chart[cur[0]][cur[1]] = cur[2];
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if (isPossible(nr, nc) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new Integer[]{nr, nc, cur[2] + 1});
                }
            }
        }
    }

    static boolean isPossible(int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= N) {
            return false;
        }
        return true;
    }

}
