package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test9019 {
    static int start;
    static int goal;
    static int minCount = Integer.MAX_VALUE;
    static String answer = "";
    static boolean checker = false;

    static LinkedList<dslrDto> list;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0 ; i<T ; i++){
            minCount = Integer.MAX_VALUE;
            list = new LinkedList<>();
            checker = false;
            arr = new boolean[10001];

            st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            goal = Integer.parseInt(st.nextToken());

            list.add(new dslrDto(start, ""));

            bfs(0);

            System.out.println(answer);
        }
    }

    public static void bfs(int count){

        dslrDto dto = list.pop();

        int value = dto.value;
        String process = dto.process;

        if(checker){
            return;
        }

        if(value == goal){
            if(count<minCount){
                answer = process;
            }
            checker = true;
            return;
        }

        int valueD = value*2%10000;
        int valueS = S(value);
        int valueL = value%1000*10 + value/1000;
        int valueR = value/10 + value%10*1000;

        if(!arr[valueD]){
            arr[valueD] = true;
            list.add(new dslrDto(valueD, process+"D"));
        }
        if(!arr[valueS]){
            arr[valueS] = true;
            list.add(new dslrDto(valueS, process+"S"));
        }
        if(!arr[valueL]){
            arr[valueL] = true;
            list.add(new dslrDto(valueL, process+"L"));
        }
        if(!arr[valueR]){
            arr[valueR] = true;
            list.add(new dslrDto(valueR, process+"R"));
        }
        bfs(count+1);
    }
    public static int S(int value){
        int valueS = value-1;
        if(valueS<0){
            return 9999;
        }
        return valueS;
    }

    static class dslrDto{
        int value;
        String process;

        dslrDto(int value, String process){
            this.value = value;
            this.process = process;
        }
    }
}
