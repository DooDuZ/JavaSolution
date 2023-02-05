package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test1389 {

    static LinkedList<ArrayList<Integer>> queue = new LinkedList<>();
    static Map<Integer, ArrayList<Integer>> userList = new HashMap<>();
    static boolean[] visited;

    static Integer[][] score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];

        score = new Integer[N+1][2];

        score[0][0] = Integer.MAX_VALUE;
        score[0][1] = Integer.MAX_VALUE;

        for(int i = 1 ; i<=N; i++){
            score[i][0] = i;
            score[i][1] = 0;
        }

        for(int i=1; i<=N; i++){
            userList.put(i, new ArrayList<Integer>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int user = Integer.parseInt(st.nextToken());
            int friend = Integer.parseInt(st.nextToken());
            userList.get(user).add(friend);
            userList.get(friend).add(user);
        }

        for(int i = 1 ; i<=N; i++){
            ArrayList<Integer> addDepth = (ArrayList<Integer>) userList.get(i).clone(); // deep copy 안해서 한참을 고생했다...
            addDepth.add(0);
            queue.add(addDepth);
            visited[i] = true;
            bfs(i);
            Arrays.fill(visited, false);
        }

        Arrays.sort( score, (e1, e2)->{
            if( e1[1]==e2[1] ){
                return e1[0]-e2[0];
            }
            return e1[1]-e2[1];
        } );

        System.out.println(score[0][0]);
    }

    static void bfs( int user ){
        if(queue.isEmpty()){
             return;
        }

        ArrayList<Integer> friendList = queue.pop();

        int depth = friendList.get(friendList.size()-1);

        for(int i = 0; i<friendList.size()-1; i++){
            int friend = friendList.get(i);
            if( !visited[friend] ){
                visited[friend] = true;
                ArrayList<Integer> addDepth = (ArrayList<Integer>) userList.get(friend).clone();
                addDepth.add(depth+1);
                queue.add(addDepth);
            }
        }
        score[user][1] += depth;
        bfs( user );
    }
}


