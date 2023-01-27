package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
    dfs와 bfs는 제법 익숙해졌다고 생각했는데 구현하는 방법을 완전히 까먹어서 그냥 내키는대로 구현했다.
    공부 다시할것..!
 */

public class test2667 {

    static int[][] arr;
    static boolean[][] visited;
    static int N;
    static ArrayList<Integer> list = new ArrayList<>();
    static int section = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0 ; i<N; i++){
            String str = br.readLine();
            for(int j = 0; j<N ; j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }

        for(int i = 0 ; i<N; i++){
            for(int j = 0; j<N ; j++){
                if(arr[i][j]==1 && !visited[i][j]){
                    countHouse(i, j, true);
                    list.add(count);
                }
            }
        }

        sb.append(list.size()).append("\n");

        Collections.sort(list);

        for(int i = 0 ; i<list.size() ; i++){
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
    }

    public static void countHouse(int x, int y, boolean first){
        if(visited[x][y] || arr[x][y] == 0){ return; }
        if(first){ section++; count = 0; }

        visited[x][y] = true;
        count++;

        if(x-1>=0){ countHouse(x-1, y, false); }
        if(x+1<N){ countHouse(x+1, y, false); }
        if(y-1>=0){ countHouse(x, y-1, false); }
        if(y+1<N){ countHouse(x, y+1, false); }
    }
}
