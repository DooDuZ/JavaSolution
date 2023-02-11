package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class test5430_2 {

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
            AC2(command);
        }
        System.out.println(sb);
    }

    public static void AC2(String command){
        char[] arr = command.toCharArray();
        boolean pointer = true;

        for(int i = 0 ; i<arr.length; i++){
            if(arr[i] == 'R'){
                pointer = !pointer;
                continue;
            }

            if(pointer){
                if(deque.pollFirst()==null){
                    sb.append("error").append("\n");
                    return;
                }

            }else {
                if(deque.pollLast()==null){
                    sb.append("error").append("\n");
                    return;
                }
            }
        }
        if (pointer){
            sb.append("[");
            if(deque.size()>=1){
                sb.append(deque.pollFirst());
            }
            while (!deque.isEmpty()){
                sb.append(",").append(deque.pollFirst());
            }
        }else {
            sb.append("[");
            if(deque.size()>=1){
                sb.append(deque.pollLast());
            }
            while (!deque.isEmpty()){
                sb.append(",").append(deque.pollLast());
            }
        }
        sb.append("]").append("\n");
    }
}

/*
1
DDD
3
[1,2,3]
*/