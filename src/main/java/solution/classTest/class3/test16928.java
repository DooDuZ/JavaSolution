package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class test16928 {

    static int N;
    static int M;

    static Integer[] dp = new Integer[101];

    static List<Slide> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 1;
        dp[5] = 1;
        dp[6] = 1;
        dp[7] = 1;

        list.add(null);

        for(int i = 1; i<=100; i++){
            list.add(new Slide(i));
        }

        // 목적지 -> 출발지로 거슬러 올라가므로 출발지와 목적지를 반대로 대입
        for(int i = 0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());

            Slide slide = list.get(destination);
            slide.state = 1;
            slide.destination = start;
        }

        for(int i = 0 ; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());

            Slide slide = list.get(start);
            slide.state = 2;
            slide.destination = destination;
        }

        move(100);
        System.out.println(dp[49]);
/*
        for(int i = 0 ; i<101; i++){
            System.out.println(dp[i]);
        }
*/
    }

    public static int move(int destination){
        if(dp[destination] == null){
            // System.out.println(destination);

            Slide slide = list.get(destination);

            int[] arr = new int[6];

            arr[0] = move(destination-1);
            arr[1] = move(destination-2);
            arr[2] = move(destination-3);
            arr[3] = move(destination-4);
            arr[4] = move(destination-5);
            arr[5] = move(destination-6);
            Arrays.sort(arr);
            if(slide.state==1){
                int prev = move(slide.destination);
                // System.out.println("destinaton" + destination+"의 " +prev);
                dp[destination] = Math.min(arr[0] + 1, prev) ;
            }else if(slide.state==2){
                dp[destination] = arr[0]+1;
                dp[slide.destination] = Math.min( dp[destination], move(slide.destination) );
            }else{
                dp[destination] = arr[0] + 1;
            }
        }
        // System.out.println(destination + " 의 최소 도달 횟수는 " + dp[destination]);
        return dp[destination];
    }
}

class Slide{
    int position;

    // 위치 정보 변수
    // 0 일반 타일 1 사다리 2 뱀
    int state;

    // 목적지
        // state 있을때만 입력
    int destination;

    Slide(int position){
        this.position = position;
    }
}


/*
반례 만들기
2 1
42 68
12 98
99 48
 */