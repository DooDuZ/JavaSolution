package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test11047 {

    static int T;
    static int money;
    static int[] arr = new int[T];
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());;
        money = Integer.parseInt(st.nextToken());

        arr = new int[T];

        for(int i = 0; i<T; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        search(T-1, 0, money);
        System.out.println(answer);

    }
    public static void search(int length, int count, int money){
        if(money==0){
            if(answer > count){
                answer = count;
            }
        }
        for(int i = length ; i>=0; i--){
            if(money / arr[i]>0){
                search(i-1, count + money / arr[i], money % arr[i]);
            }
        }
    }
}
