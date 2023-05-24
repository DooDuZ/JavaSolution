package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test1202 {

    static int N;
    static int K;
    static PriorityQueue<Integer> bags = new PriorityQueue<>();
    static PriorityQueue<Jewel> pq = new PriorityQueue<>( (e1,e2)->{
        return e2.value - e1.value;
    });
    static PriorityQueue<Jewel> jewels = new PriorityQueue<>( (e1,e2)->{
        return e1.weight - e2.weight;
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        long answer = 0;

        for(int i = 0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            jewels.add(new Jewel(weight, value));
        }

        for(int i = 0; i<K; i++){
            int weight = Integer.parseInt(br.readLine());
            bags.add(weight);
        }

        while(!bags.isEmpty()){
            int weight = Math.min(bags.poll(), 1000000);

            while(!jewels.isEmpty() && jewels.peek().weight <= weight){
                pq.add(jewels.poll());
            }
            if(pq.isEmpty()) continue;
            answer += pq.poll().value;
        }

        System.out.println(answer);
    }
}

class Jewel{
    int weight;
    int value;
    Jewel(int weight, int value){
        this.weight = weight;
        this.value = value;
    }
}