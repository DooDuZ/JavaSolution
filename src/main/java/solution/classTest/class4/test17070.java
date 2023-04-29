package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 입력 데이터가 작아서 dp는 따로 안했음
    // 역방향으로 목표점까지 갈 수 있는 경우의 수만 따지면 쉽게 적용 가능할듯
    // 혹은 현재 before + cur 에서 목표점에 도달할 수 있는지 true false로 판단해서 바로 count를 올려주는 방법도 있을듯..?
public class test17070 {
    static int N;
    static int[][] room;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        room = new int[N][N];

        StringTokenizer st;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move(new int[][]{ {0,0}, {0,1} });

        System.out.println(count);
    }

    public static void move(int[][] position){
        int[] before = position[0];
        int[] cur = position[1];

        if(cur[0] == N-1 && cur[1] == N-1){
            count++;
            return;
        }

        int valueRow = cur[0] - before[0];
        int valueCol = cur[1] - before[1];

        if( valueCol==1 && valueRow==0 && cur[1]+1<N ){ // 가로로 놓여진 경우
            if( room[cur[0]][cur[1]+1] == 0 ){
                move( new int[][]{ cur, { cur[0], cur[1]+1 } } );
            }
            if( cur[0]+1<N && room[cur[0]][cur[1]+1] == 0 && room[cur[0]+1][cur[1]] == 0 && room[cur[0]+1][cur[1]+1] == 0 ){
                move( new int[][]{ cur, {cur[0]+1, cur[1]+1 } } );
            }
        }

        if( valueCol==0 && valueRow==1 && cur[0]+1<N ){ // 세로로 놓여진 경우
            if( room[cur[0]+1][cur[1]] == 0 ){
                move( new int[][]{ cur, { cur[0]+1, cur[1] } } );
            }
            if( cur[1]+1<N && room[cur[0]][cur[1]+1] == 0 && room[cur[0]+1][cur[1]] == 0 && room[cur[0]+1][cur[1]+1] == 0 ){
                move( new int[][]{ cur, {cur[0]+1, cur[1]+1 } } );
            }
        }

        if( valueCol==1 && valueRow==1 ){ // 대각선으로 놓여진 경우
            if( cur[0]+1<N && room[cur[0]+1][cur[1]] == 0){
                move( new int[][]{ cur, { cur[0]+1, cur[1] } } );
            }
            if( cur[1]+1<N && room[cur[0]][cur[1]+1] == 0){
                move( new int[][]{ cur, { cur[0], cur[1]+1 } } );
            }
            if( cur[0]+1<N && cur[1]+1<N && room[cur[0]][cur[1]+1] == 0 && room[cur[0]+1][cur[1]] == 0 && room[cur[0]+1][cur[1]+1] == 0 ){
                move( new int[][]{ cur, {cur[0]+1, cur[1]+1 } } );
            }
        }
    }
}
