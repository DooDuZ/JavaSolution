package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test12850 {
    public static void main(String[] args) throws IOException{
        int D = input();

        if(D <= 1){
            System.out.println(0);
            return;
        }

        System.out.println(walk(D));
    }

    static public int walk(int time){
        return 0;
    }

    static int input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }
}
