package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test2178 {
    static int x;
    static int y;
    static int[][] board;
    static boolean[][] visited;
    static LinkedList<Integer[]> list = new LinkedList<>();
    static int count = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        board = new int[x][y];
        visited = new boolean[x][y];

        for(int i = 0; i<x; i++){
            String str = br.readLine();
            for(int j = 0; j<y; j++){
                board[i][j] = str.charAt(j)-'0';
            }
        }

        Integer[] position = {0, 0, 1};
        list.add(position);

        bfs();

        System.out.println(count);
    }

    public static void bfs(){
        if(list.isEmpty()){
            return;
        }

        Integer[] position = list.pop();

        int row = position[0];
        int col = position[1];
        int distance = position[2];

        if( row==x-1 && col==y-1 ){
            if(count>distance){
                count = distance;
            }
            return;
        }

        if(row + 1 < x && !visited[row+1][col] && board[row+1][col] == 1){
            visited[row+1][col] = true;
            list.add( new Integer[]{ row+1,col, distance+1 } );
        }
        if(row - 1 >= 0 && !visited[row-1][col] && board[row-1][col] == 1){
            visited[row-1][col] = true;
            list.add( new Integer[]{ row-1,col, distance+1 } );
        }
        if(col + 1 < y && !visited[row][col+1] && board[row][col+1] == 1){
            visited[row][col+1] = true;
            list.add( new Integer[]{ row, col+1, distance+1 } );
        }
        if(col - 1 >= 0 && !visited[row][col-1] && board[row][col-1] == 1){
            visited[row][col-1] = true;
            list.add( new Integer[]{ row, col-1, distance+1 } );
        }
        bfs();
    }
}