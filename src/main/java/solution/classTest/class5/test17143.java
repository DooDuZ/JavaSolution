package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class test17143 {

    static int R;
    static int C;
    static int M;
    static ArrayList<Shark> list = new ArrayList<>();
    static ArrayList<Shark>[][] pool;

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pool = new ArrayList[R][C];

        for(int i = 1 ; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            list.add(new Shark(i, row, col, speed, direction, size));
        }

        eatSmall();

        for(int i = 1; i<=C; i++){
            getShark(i-1);
            // System.out.println(answer);
            moveShark();
            eatSmall();
        }

        System.out.println(answer);
    }

    public static void getShark(int position){
        for(int i = 0 ; i < R; i++){
            ArrayList<Shark> cell = pool[i][position];
            if(cell.isEmpty()){ continue; }
            for (Shark shark : cell){
                if(shark.survive){
                    // System.out.println( (position+1) + "번 턴에" + shark.size+"크기의 "+shark.idx + "번 상어를 잡았다!");
                    shark.survive = false;
                    answer += shark.size;
                    return;
                }
            }
        }
    }

    public static void eatSmall(){
        for(int i = 0 ; i<R; i++){
            for(int j = 0 ; j<C; j++){
                pool[i][j] = new ArrayList<>();
            }
        }

        for (Shark shark : list){
            if(shark.survive){
                pool[shark.row-1][shark.col-1].add(shark);
            }
        }

        for(int i = 0 ; i<R; i++){
            for(int j = 0 ; j<C; j++){
                if(pool[i][j].size() > 1){
                    Collections.sort(pool[i][j], (e1,e2)->{
                        return e2.size-e1.size;
                    });
                }
                for (int k = 1; k<pool[i][j].size(); k++){
                    // System.out.println(pool[i][j].get(k).idx + "번 상어가 " + pool[i][j].get(0).idx +"번 상어에게 잡아먹혔어요.");
                    pool[i][j].get(k).survive = false;
                }
            }
        }
    }

    public static void moveShark(){
        for(int i = 0 ; i<list.size(); i++){
            Shark shark = list.get(i);
            if(!shark.survive){ continue; }
            setPosition(shark);
        }
    }

    public static void setPosition(Shark shark){
        if(shark.direction==1){
            int speed = shark.speed;

            if(shark.row-speed > 1){
                shark.row -= speed;
            }else if(shark.row-speed == 1){
                shark.direction = 2;
                shark.row = 1;
            }else if(shark.row-speed < 1){
                speed -= shark.row-1;
                if((speed / (R-1)) % 2 == 0){
                    shark.direction = 2;
                    shark.row = 1 + speed % (R-1);
                }else{
                    shark.direction = 1;
                    shark.row = R-(speed % (R-1));
                }
            }
        }else if(shark.direction==2){
            int speed = shark.speed;

            if(shark.row+speed < R){
                shark.row += speed;
            }else if(shark.row+speed == R){
                shark.direction = 1;
                shark.row = R;
            }else if(shark.row+speed > R){
                speed -= R-shark.row;
                if((speed / (R-1)) % 2 == 0){
                    shark.direction = 1;
                    shark.row = R - (speed % (R-1));
                }else{
                    shark.direction = 2;
                    shark.row = 1 + (speed % (R-1));
                }
            }
        }else if(shark.direction==3){
            int speed = shark.speed;

            if(shark.col+speed < C){
                shark.col += speed;
            }else if(shark.col+speed == C){
                shark.direction = 4;
                shark.col = C;
            }else if(shark.col+speed > C){
                speed -= C-shark.col;
                if((speed / (C-1)) % 2 == 0){
                    shark.direction = 4;
                    shark.col = C - (speed%(C-1));
                }else{
                    shark.direction = 3;
                    shark.col = 1 + (speed % (C-1));
                }
            }
        }else {
            int speed = shark.speed;

            if(shark.col-speed > 1){
                shark.col -= speed;
            }else if(shark.col-speed == 1){
                shark.direction = 3;
                shark.col = 1;
            }else if(shark.col-speed < 1){
                speed -= (shark.col-1);
                if((speed / (C-1)) % 2 == 0){
                    shark.direction = 3;
                    shark.col = 1+(speed % (C-1));
                }else{
                    shark.direction = 4;
                    shark.col = C -(speed % (C-1));
                }
            }
        }
    }

}

class Shark{
    int idx;
    int row;
    int col;
    int speed;;
    int direction;
    int size;

    boolean survive = true;

    Shark(int idx, int row, int col, int speed, int direction, int size){
        this.idx = idx;
        this.row = row;
        this.col = col;
        this.speed = speed;
        this.direction = direction;
        this.size = size;
    }
}