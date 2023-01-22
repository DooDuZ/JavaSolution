package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test7662_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        DoubleHeap doubleHeap;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int row = Integer.parseInt(br.readLine());
            doubleHeap = new DoubleHeap();
            for (int j = 0; j < row; j++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int value = Integer.parseInt(st.nextToken());
                if (command.equals("I")) {
                    doubleHeap.add(value);
                } else {
                    if (doubleHeap.isEmpty()) {
                        continue;
                    }
                    if (value == 1) {
                        if (doubleHeap.size() != 0) {
                            doubleHeap.pop();
                        }
                    } else {
                        if (doubleHeap.size() != 0) {
                            doubleHeap.popLast();
                        }
                    }
                }
            }
            if (doubleHeap.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                int max = doubleHeap.pop();
                int min;
                if(doubleHeap.isEmpty()){
                    min = max;
                }else{
                   min = doubleHeap.popLast();
                }
                sb.append(max).append(" ").append(min).append("\n");
            }
        }
        System.out.println(sb);
    }
}

class DoubleHeap{
    PriorityQueue<Integer> orderList = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> reverseList = new PriorityQueue<>();
    Map<Integer, Integer> map = new HashMap<>();

    int size = 0;

    void add(int value){
        size++;
        orderList.add(value);
        reverseList.add(value);
        map.put(value, map.getOrDefault(value, 0)+1);
    }

    int pop(){
        if(map.get(orderList.peek()) <= 0 ){
            while(true){
                orderList.poll();
                if(map.get(orderList.peek())!=0){
                    break;
                }
            }
        }
        map.put(orderList.peek(), map.get(orderList.peek())-1);
        size--;
        return orderList.peek();
    }

    int popLast(){
        if(map.get(reverseList.peek()) <= 0 ){
            while(true){
                reverseList.poll();
                if(map.get(reverseList.peek())!=0){
                    break;
                }
            }
        }
        map.put(reverseList.peek(), map.get(reverseList.peek())-1);
        size--;
        return reverseList.peek();
    }

    boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }

    int size(){
        return size;
    }
}
/*
1
9
I 36
I 37
I 38
D 1
D 1
I 39
I 40
D -1
D -1
 */