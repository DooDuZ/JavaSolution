package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test14502 {

    static int N;
    static int M;

    static int[][] board;   // 연구소 좌표 저장
    static boolean[][] visited; // dfs용 방문 배열
    static boolean[][] virusV;  // bfs용 방문 배열

    static int maxArea = Integer.MIN_VALUE; // 최대값

    static LinkedList<Integer[]> queue = new LinkedList<>(); // bfs용 queue

    static int normalArea = 0;  // 일반 구역
    static ArrayList<Integer[]> vPositions = new ArrayList<>(); // 바이러스의 위치

    static int virus = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];
        virusV = new boolean[N][M];

        for(int i = 0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==0){
                    normalArea++;
                }else if(board[i][j]==2){
                    vPositions.add(new Integer[]{i,j});
                }
            }
        }

        dfs(0);

        System.out.println(maxArea);
    }

    public static void dfs(int depth){
        if(depth == 3){
            int[][] walls = new int[N][M];
            for(int i = 0 ; i<N; i++){
                walls[i] = board[i].clone();
            }
            virusV = new boolean[N][M];
            for(int i = 0; i<vPositions.size(); i++){
                Integer[] position = vPositions.get(i);
                virusV[position[0]][position[1]] = true;
                queue.add(new Integer[]{position[0], position[1]});
                bfs(walls);
            }
            maxArea = Math.max(normalArea-virus-3, maxArea);

            virus = 0;
            return;
        }

        for(int i = 0 ; i<N; i++){
            for(int j = 0 ; j<M; j++){
                if(!visited[i][j] && board[i][j]==0){
                    visited[i][j] = true;
                    board[i][j] = 1;
                    dfs(depth+1);
                    board[i][j] = 0;
                    visited[i][j] = false;
                }
            }
        }
    }

    public static void bfs(int[][] wallBoard){
        if(queue.isEmpty()){
            return;
        }

        Integer[] position = queue.pop();

        int row = position[0];
        int col = position[1];

        if(row-1>=0 && !virusV[row-1][col] && wallBoard[row-1][col] == 0){
            virusV[row-1][col] = true;
            wallBoard[row-1][col] = 2;
            queue.add(new Integer[]{row-1, col});
            virus++;
        }
        if(row+1<N && !virusV[row+1][col] && wallBoard[row+1][col] == 0){
            virusV[row+1][col] = true;
            wallBoard[row+1][col] = 2;
            queue.add(new Integer[]{row+1, col});
            virus++;
        }
        if(col-1>=0 && !virusV[row][col-1] && wallBoard[row][col-1] == 0){
            virusV[row][col-1] = true;
            wallBoard[row][col-1] = 2;
            queue.add(new Integer[]{row, col-1});
            virus++;
        }
        if(col+1<M && !virusV[row][col+1] && wallBoard[row][col+1] == 0){
            virusV[row][col+1] = true;
            wallBoard[row][col+1] = 2;
            queue.add(new Integer[]{row, col+1});
            virus++;
        }
        bfs(wallBoard);
    }
}
