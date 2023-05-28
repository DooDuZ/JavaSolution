package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 위상 정렬
public class test2252 {

    static int N;
    static int M;
    static LinkedList<Integer> queue = new LinkedList<>();
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        count = new int[N];

        for(int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0 ; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;

            list.get(from).add(to);
            count[to]++;
        }

        for(int i = 0 ; i<N; i++){
            if(count[i]==0){
                queue.push(i);
            }
        }

        topologySort();

        System.out.println(sb.toString());
    }

    public static void topologySort(){
        if(queue.isEmpty()){
            return;
        }

        int cur = queue.poll();
        sb.append(cur+1).append(" ");

        ArrayList<Integer> next = list.get(cur);
        for(Integer tmp : next){
            count[tmp]--;
            if(count[tmp]==0){
                queue.add(tmp);
            }
        }

        topologySort();
    }
}


/*
10 9
1 9
2 9
3 9
4 9
5 9
6 9
7 9
8 9
9 10


5 4
1 3
2 3
3 4
5 4


3 3
2 1
3 2
3 1
 */