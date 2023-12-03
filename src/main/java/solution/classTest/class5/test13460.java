package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dfs 사용
public class test13460 {
    static int N;
    static int M;
    static char[][] map;
    static boolean[][][][] visited;
    static int redR, redC, blueR, blueC, exitR, exitC;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int answer = Integer.MAX_VALUE;

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

        dfs(0);

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        System.out.println(answer);
    }


    static void dfs(int depth) {
        if (depth > 10 || depth >= answer || (blueR == exitR && blueC == exitC)) {
            return;
        }

        if (redR == exitR && redC == exitC) {
            answer = Math.min(depth, answer);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int prevRedR = redR;
            int prevRedC = redC;
            int prevBlueR = blueR;
            int prevBlueC = blueC;

            if (!checkPath(redR, redC, blueR, blueC, i)) {
                while (map[blueR + dr[i]][blueC + dc[i]] != '#') {
                    if (blueR == exitR && blueC == exitC) {
                        break;
                    }
                    blueR += dr[i];
                    blueC += dc[i];
                }
                while (map[redR + dr[i]][redC + dc[i]] != '#' && (redR + dr[i] != blueR || redC + dc[i] != blueC)) {
                    if (redR == exitR && redC == exitC) {
                        break;
                    }
                    redR += dr[i];
                    redC += dc[i];
                }

                if (visited[redR][redC][blueR][blueC]) {
                    redR = prevRedR;
                    redC = prevRedC;
                    blueR = prevBlueR;
                    blueC = prevBlueC;
                    continue;
                }

                visited[redR][redC][blueR][blueC] = true;
            } else {
                while (map[redR + dr[i]][redC + dc[i]] != '#') {
                    if (redR == exitR && redC == exitC) {
                        break;
                    }
                    redR += dr[i];
                    redC += dc[i];
                }

                while (map[blueR + dr[i]][blueC + dc[i]] != '#' && ((blueR + dr[i] != redR || blueC + dc[i] != redC)
                        || (
                        blueR + dr[i] == exitR && blueC + dc[i] == exitC))) {
                    if (blueR == exitR && blueC == exitC) {
                        break;
                    }
                    blueR += dr[i];
                    blueC += dc[i];
                }

                if (visited[redR][redC][blueR][blueC]) {
                    redR = prevRedR;
                    redC = prevRedC;
                    blueR = prevBlueR;
                    blueC = prevBlueC;
                    continue;
                }
                visited[redR][redC][blueR][blueC] = true;
            }

            dfs(depth + 1);

            visited[redR][redC][blueR][blueC] = false;

            while (prevRedR != redR || prevRedC != redC) {
                redR -= dr[i];
                redC -= dc[i];
            }

            while (prevBlueR != blueR || prevBlueC != blueC) {
                blueR -= dr[i];
                blueC -= dc[i];
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
}

/*
10 10
##########
#RB....#.#
#..#.....#
#........#
#.O......#
#...#....#
#........#
#........#
#.......##
##########

ans : 10

3 6
######
#.ORB#
######

ans : -1

8 8
########
#.####.#
#...#B##
#.##.R.#
######.#
##.##O.#
###.##.#
########

ANS:7

4 6
######
#R####
#B..O#
######

ANS:-1

4 6
######
#R#O##
#B...#
######

ANS:4

8 10
##########
#.......O#
###.#.#.##
#........#
#B#.###..#
##.....#.#
#R...#...#
##########

ans 10

5 10
##########
#.#......#
##.......#
#OR..B.#.#
##########

ans 7

4 5
#####
#.BR#
#.O##
#####

 */