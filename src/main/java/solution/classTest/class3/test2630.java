package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2630 {

    static int[][] paper;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        StringTokenizer st;

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cutPaper(N, 0, 0);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void cutPaper(int N, int startX, int startY){

        int value = paper[startX][startY];

        for(int i = startX; i<startX+N; i++){
            for(int j = startY; j<startY+N; j++){
                if( paper[i][j] != value ){
                    cutPaper(N/2, startX, startY); // 2분면
                    cutPaper(N/2, startX+N/2, startY); // 1분면
                    cutPaper(N/2, startX+N/2, startY+N/2); // 4분면
                    cutPaper(N/2, startX, startY+N/2); // 2분면
                    return;
                }
            }
        }

        if(value==0){
            white++;
        }else{
            blue++;
        }
    }
}
