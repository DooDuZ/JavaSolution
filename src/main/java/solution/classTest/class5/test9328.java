package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test9328 {
    static int answer = 0;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            char[][] floor = new char[h+2][w+2];
            Set<Character> keys = new HashSet<>();
            int keyCount = 0;

            for(int j = 0 ; j<h+2; j++){
                Arrays.fill(floor[j], '.');
            }

            for(int j = 1; j<=h; j++){
                String row = br.readLine();

                for( int k = 0 ; k<row.length(); k++){
                    floor[j][k+1] = row.charAt(k);
                }
            }

            String keyInit = br.readLine();
            if(!keyInit.equals('0')){
                for(char key : keyInit.toCharArray()){
                    keys.add(key);
                }
            }

            keyCount = keys.size();

            LinkedList<Integer[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[h+2][w+2];

            visited[0][0] = true;
            queue.add(new Integer[]{0,0});
            bfs(queue, floor, visited, keys);
            while (keyCount!=keys.size()){
                keyCount = keys.size();
                visited = new boolean[h+2][w+2];

                visited[0][0] = true;
                queue.add(new Integer[]{0,0});
                bfs(queue, floor, visited, keys);
            }

            sb.append(answer).append("\n");
            answer = 0;
        }

        System.out.println(sb);
    }

    public static void bfs(LinkedList<Integer[]> queue, char[][] floor, boolean[][] visited, Set<Character> keys){
        if(queue.isEmpty()){
            return;
        }

        Integer[] coords = queue.pop();
        int row = coords[0];
        int col = coords[1];

        char cur = floor[row][col];

        // 방문한 곳에 문서가 있으면
        if(cur=='$'){
            answer++;                   // 문서 획득
            floor[row][col] = '.';      // 일반 통로로 변경
        }

        // 방문한 곳에 열쇠가 있으면
        if(cur >= 97 && cur <= 122){
            keys.add( cur );            // 키 목록에 추가
            floor[row][col] = '.';      // 통로로 변경
        }

        for(int i = 0; i<4; i++){
            int r = row + dy[i];
            int c = col + dx[i];

            if(check(r,c, floor.length, floor[0].length) && !visited[r][c]){
                char next = floor[r][c];
                if(next=='*'){                              // 벽이면 continue;
                    continue;
                }else if(next>=65 && next<=90){             // 문이면
                    if(keys.contains( (char) (next+32) )){  // 키가 있으면 통로로 변경
                        floor[r][c] = '.';
                    }else{                                  // 키가 없으면 지나갈 수 없으니 continue;
                        continue;
                    }
                }
                visited[r][c] = true;
                queue.add(new Integer[]{r,c});
            }
        }
        bfs(queue, floor, visited, keys);
    }

    public static boolean check(int row, int col, int h, int w){
        if(row<0 || row>=h || col<0 || col>=w){
            return false;
        }
        return true;
    }
}
