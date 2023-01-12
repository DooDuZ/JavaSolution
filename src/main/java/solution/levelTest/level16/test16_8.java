package solution.levelTest.level16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
// dp 필요
public class test16_8 {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static Map<String, Integer> map = new HashMap<>();
    static Stack<Integer> start = new Stack<>();
    static Stack<Integer> link = new Stack<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st;
        for(int i = 0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, "");

        System.out.println(min);
    }

    public static void dfs(int depth, int num, String key){
        if(depth == N/2){
            link = new Stack<>();
            for(int i = 0; i<N; i++){
                if(!start.contains(i)){
                    link.push(i);
                }
            }
            int score = Math.abs( getSum(start) - getSum(link) );
            if(score < min) {
                min = score;
            }
/*
            for(int i = 0 ; i<start.size(); i++){
                System.out.print( start.get(i) + " " );
            }
            System.out.println("start");

            for(int i = 0 ; i<start.size(); i++){
                System.out.print( link.get(i) + " " );
            }
            System.out.println("link");
*/

            return;
        }

        for(int i = num; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                start.push(i);
                dfs(depth+1, i+1, key+String.valueOf(i));
                visited[i] = false;
                start.pop();
            }
        }
    }
    public static int getSum(Stack<Integer> team){
        String str = "";
        for(int i = 0; i<team.size(); i++){
            str += String.valueOf(team.get(i));
        }

        if (map.containsKey(str)){
            return map.get(str);
        }

        int score = 0;
        for(int i = 0; i<team.size(); i++){
            for(int j = 0 ; j<team.size(); j++){
                if(i==j){ continue; }
                score += arr[team.get(i)][team.get(j)];
            }
        }
        return score;
    }
}
