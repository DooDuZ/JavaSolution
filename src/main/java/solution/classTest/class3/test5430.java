package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test5430 {

    static ArrayDeque<Integer> deque;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i<T; i++){
            String command = br.readLine();
            int N = Integer.parseInt(br.readLine());
            deque = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine(),"[],");
            for(int j = 0; j<N; j++){
                deque.add(Integer.parseInt(st.nextToken()));
            }
            AC(command);
        }
        System.out.println(sb);
    }

    public static void AC(String command){
        boolean pointer = true; // 값을 제거할 방향 true = first | false = last

        for(int j = 0 ; j<command.length(); j++){
            if(command.charAt(j)=='R'){
                pointer = !pointer;
                continue;
            }

            if(pointer){
                if(deque.pollFirst()==null){
                    sb.append("error").append("\n");
                    return;
                }
            }else{
                if (deque.pollLast()==null){
                    sb.append("error").append("\n");
                    return;
                }
            }
        }

        sb.append("[");
        if(pointer){
            sb.append(deque.pollFirst());
            while(!deque.isEmpty()){
                sb.append(",").append(deque.pollFirst());
            }
        }else{
            sb.append(deque.pollLast());
            while(!deque.isEmpty()){
                sb.append(",").append(deque.pollLast());
            }
        }
        sb.append("]").append("\n");
    }
}