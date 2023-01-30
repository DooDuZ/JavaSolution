package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1780 {

    static int[][] paper;
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        StringTokenizer st;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cutPaper( N, 0, 0 );

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    public static void cutPaper(  int N, int startX, int startY ){

        int value = paper[startX][startY];

        for(int i = startX ; i<startX+N; i++){
            for(int j = startY ; j<startY+N; j++){

                if(paper[i][j] != value){
                    cutPaper( N/3, startX, startY);
                    cutPaper( N/3, startX+N/3, startY);
                    cutPaper( N/3, startX+2*N/3, startY);

                    cutPaper( N/3, startX, startY+N/3);
                    cutPaper( N/3, startX+N/3, startY+N/3);
                    cutPaper( N/3, startX+2*N/3, startY+N/3);

                    cutPaper( N/3, startX, startY+2*N/3);
                    cutPaper( N/3, startX+N/3, startY+2*N/3);
                    cutPaper( N/3, startX+2*N/3, startY+2*N/3);

                    return;
                }
            }
        }

        if(value==-1){
            minus++;
        }else if(value==0){
            zero++;
        }else{
            plus++;
        }
    }
}

/*
    if(startX>=6){
                    System.out.println("value : " + value);
                    System.out.println("paper : " + paper[i][j]);
                }

 */