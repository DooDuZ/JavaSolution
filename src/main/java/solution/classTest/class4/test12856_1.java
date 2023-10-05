package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 효율을 통한 접근
    // 오답. 효율적으로 접근하여 무게가 남는 경우보다
    // 효율이 조금 떨어지더라도 무게를 꽉 채워서 더 높은 value를 챙기는 경우가 나올 수 있음
    // 결국 dp로 접근해야 할듯... dp는 항상 어렵다. 실버만 봐도 헤매는데 뭔 골드여 골드는...
    // 내일 다시 풀어볼 것

public class test12856_1 {
    static int N;
    static int K;
    static PriorityQueue<Obj> pq = new PriorityQueue<Obj>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int totalValue = 0;
        int totalWeight = 0;

        for(int i = 0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            Obj cur = new Obj(weight, value);
            pq.add(cur);
        }

        boolean check = true;
        while(check && !pq.isEmpty()){
            while( !pq.isEmpty() && totalWeight+pq.peek().weight <= K){
                Obj cur = pq.poll();

                totalValue += cur.value;
                totalWeight += cur.weight;
                check = false;
            }
            pq.poll();
        }

        System.out.println(totalValue);
    }
}

class Obj implements Comparable<Obj>{
    int weight;
    int value;
    double grade;
    Obj(int weight, int value){
        this.weight = weight;
        this.value = value;
        grade = (double) value / weight;
    }

    @Override
    public int compareTo(Obj o){
        if(this.grade == o.grade){
            return 0;
        }else if(this.grade > o.grade){
            return 1;
        }
        return -1;
    }
}