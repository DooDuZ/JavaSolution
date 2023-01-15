package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class test11279_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        PriorityQueue maxHeap = new PriorityQueue(Collections.reverseOrder());

        for(int i = 0 ; i<T; i++){
            int value = Integer.parseInt(br.readLine());
            if(value==0){
                if (maxHeap.isEmpty()){
                    sb.append(0);
                }else{
                    sb.append(maxHeap.poll());
                }
                sb.append("\n");
            }else{
                maxHeap.add(value);
            }
        }
        System.out.println(sb);
    }
}