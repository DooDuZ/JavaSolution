package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

// bfs 사용
public class test15644 {
    static int N;
    static int M;
    static char[][] map;
    static boolean[][][][] visited;
    static int redR, redC, blueR, blueC, exitR, exitC;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int answer = Integer.MAX_VALUE;
    static char[] commands = {'D', 'U', 'R', 'L'};
    static LinkedList<Records> queue = new LinkedList<>();

    static ArrayList<Integer> commandStore;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                char data = row.charAt(j);

                if (data == 'R') {
                    redR = i;
                    redC = j;
                    data = '.';
                } else if (data == 'B') {
                    blueR = i;
                    blueC = j;
                    data = '.';
                } else if (data == 'O') {
                    exitR = i;
                    exitC = j;
                    data = '.';
                }

                map[i][j] = data;
            }
        }
        visited[redR][redC][blueR][blueC] = true;

        queue.add( new Records(new Integer[]{redR, redC, blueR, blueC, 0}, new ArrayList<>()));

        bfs();

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        StringBuilder sb = new StringBuilder();

        System.out.println(answer);
        if(commandStore != null){
            for(Integer index : commandStore){
                sb.append(commands[index]);
            }
            System.out.println(sb);
        }
    }


    static void bfs() {
        while (!queue.isEmpty()) {
            Records now = queue.poll();
            Integer[] cur = now.coords;

            int curRedR = cur[0];
            int curRedC = cur[1];
            int curBlueR = cur[2];
            int curBlueC = cur[3];
            int cost = cur[4];

            if (cost>10 || cost >= answer || (curBlueR == exitR && curBlueC == exitC)) {
                continue;
            }

            if (curRedR == exitR && curRedC == exitC) {
                answer = Math.min(cost, answer);
                commandStore = now.command;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextRedR = curRedR;
                int nextRedC = curRedC;
                int nextBlueR = curBlueR;
                int nextBlueC = curBlueC;

                if (!checkPath(nextRedR, nextRedC, nextBlueR, nextBlueC, i)) {
                    while (map[nextBlueR + dr[i]][nextBlueC + dc[i]] != '#') {
                        if (nextBlueR == exitR && nextBlueC == exitC) {
                            break;
                        }
                        nextBlueR += dr[i];
                        nextBlueC += dc[i];
                    }

                    while (map[nextRedR + dr[i]][nextRedC + dc[i]] != '#' && (nextRedR + dr[i] != nextBlueR
                            || nextRedC + dc[i] != nextBlueC)) {
                        if (nextRedR == exitR && nextRedC == exitC) {
                            break;
                        }
                        nextRedR += dr[i];
                        nextRedC += dc[i];
                    }

                    if (visited[nextRedR][nextRedC][nextBlueR][nextBlueC]) {
                        continue;
                    }

                    visited[nextRedR][nextRedC][nextBlueR][nextBlueC] = true;
                    ArrayList<Integer> next = new ArrayList<>(now.command);
                    next.add(i);
                    queue.add(new Records(new Integer[]{nextRedR, nextRedC, nextBlueR, nextBlueC, cost + 1}, next));
                } else {
                    while (map[nextRedR + dr[i]][nextRedC + dc[i]] != '#') {
                        if (nextRedR == exitR && nextRedC == exitC) {
                            break;
                        }
                        nextRedR += dr[i];
                        nextRedC += dc[i];
                    }

                    while (map[nextBlueR + dr[i]][nextBlueC + dc[i]] != '#' && (
                            ((nextBlueR + dr[i] != nextRedR || nextBlueC + dc[i] != nextRedC)) ||
                                    (nextBlueR + dr[i] == exitR && nextBlueC + dc[i] == exitC))) {
                        if (nextBlueR == exitR && nextBlueC == exitC) {
                            break;
                        }
                        nextBlueR += dr[i];
                        nextBlueC += dc[i];
                    }

                    if (visited[nextRedR][nextRedC][nextBlueR][nextBlueC]) {
                        continue;
                    }

                    visited[nextRedR][nextRedC][nextBlueR][nextBlueC] = true;
                    ArrayList<Integer> next = new ArrayList<>(now.command);
                    next.add(i);
                    queue.add(new Records(new Integer[]{nextRedR, nextRedC, nextBlueR, nextBlueC, cost + 1}, next));
                }
            }
        }
    }

    static boolean checkPath(int moveR, int moveC, int otherR, int otherC, int dIndex) {
        while (map[moveR][moveC] != '#') {
            moveR += dr[dIndex];
            moveC += dc[dIndex];

            if (moveR == otherR && moveC == otherC) {
                return false;
            }
        }
        return true;
    }

    static class Records{
        Integer[] coords;
        ArrayList<Integer> command = new ArrayList<>();

        Records(Integer[] coords, ArrayList<Integer> next){
            this.coords = coords;
            this.command = next;
        }
    }
}