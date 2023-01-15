package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        PriorityQueue<Integer> queue;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i<T; i++){
            int row = Integer.parseInt(br.readLine());
            queue = new PriorityQueue<>();
            for(int j = 0 ; j<row; j++){
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int value = Integer.parseInt(st.nextToken());
                if(command.equals("I")){
                    queue.add(value);
                }else{
                    if(queue.isEmpty()){
                        continue;
                    }
                    if(value == 1){
                        int max = Integer.MIN_VALUE;
                        for(int tmp : queue){
                            if(tmp>max){
                                max = tmp;
                            }
                        }
                        queue.remove(max);
                    }else{
                        queue.poll();
                    }
                }
            }
            if(queue.isEmpty()){
                sb.append("EMPTY").append("\n");
            }else{
                int max = Integer.MIN_VALUE;

                for(int tmp : queue){
                    if(tmp>max){
                        max = tmp;
                    }
                }
                sb.append(max).append(" ").append(queue.peek()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
