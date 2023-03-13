package solution.levelTest.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test1021 {

    static LinkedList<Integer> deque = new LinkedList<>();

    static LinkedList<Integer> pickUp = new LinkedList<>();

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i<N; i++){
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<M; i++){
            pickUp.add(deque.get(Integer.parseInt(st.nextToken())-1));
        }

        while (!pickUp.isEmpty()){
            Integer value = pickUp.poll();
            int idx = deque.indexOf(value);
            if( idx > deque.size()/2 ){
                count += deque.size()-idx;
                for(int i = 0 ; i< deque.size()-idx; i++ ){
                    shiftR();
                }
            }else{
                count += idx;
                for(int i = 0 ; i<idx; i++){
                    shiftL();
                }
            }
            deque.poll();
        }

        System.out.println(count);
    }

    public static void shiftR(){
        Integer value = deque.pollLast();
        deque.addFirst(value);
    }

    public static void shiftL(){
        Integer value = deque.poll();
        deque.addLast(value);
    }
}
