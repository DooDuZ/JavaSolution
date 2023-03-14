package solution.programmers;

import java.util.ArrayList;
import java.util.*;

public class Kakao2023_cellMerge {

    public static void main(String[] args) {
        String[] commands = new String[]{ "UPDATE 1 1 123", "UPDATE 2 2 234", "UPDATE 3 3 345", "UPDATE 4 4 456", "MERGE 1 1 4 4", "UNMERGE 1 1" ,"UPDATE 1 1 234", "UPDATE 6 7 VALUE", "UPDATE 234 null", "UPDATE null VALUE", "MERGE 8 8 9 9", "UPDATE 8 8 DATA" };

        solution(commands);
    }

    // map으로 연산을 좀 줄여보려 했으나... 대실패
        // 실제 제출은 map 삭제 후 반복문을 통한 전체 탐색으로 update 진행
    // static Map< String, ArrayList<Integer[]>> map = new HashMap<>();
    static Box[][] chart = new Box[50][50];
    static ArrayList<String> answerList = new ArrayList<>();

    public static String[] solution(String[] commands) {
        String[] answer = {};

        for(int i = 0 ; i<commands.length; i++){
            String target = commands[i];
            String[] current = target.split(" ");
            String command = current[0];

            if( command.equals("UPDATE") && current.length == 3){
                update( current[1], current[2] );

                for(int j = 0 ; j<50; j++){
                    for(int k=0; k<50; k++){
                        if(chart[j][k]==null){
                            System.out.print("* ");
                        }else{
                            System.out.print(chart[j][k].str+" ");
                        }
                    }
                    System.out.println();
                }

                continue;
            }

            int r = Integer.parseInt( current[1] )-1;
            int c = Integer.parseInt( current[2] )-1;

            if(command.equals("UPDATE")){
                update( r, c, current[3] );
            }else if(command.equals("MERGE")){
                merge(r, c, Integer.parseInt(current[3])-1, Integer.parseInt(current[4])-1);
            }else if(command.equals("UNMERGE")){
                unMerge(r, c);
            }else{
                print(r, c);
            }

            System.out.println();
            for(int j = 0 ; j<50; j++){
                for(int k=0; k<50; k++){
                    if(chart[j][k]==null){
                        System.out.print("* ");
                    }else{
                        System.out.print(chart[j][k].str+" ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }

        answer = new String[answerList.size()];

        for(int i = 0 ; i<answer.length; i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public static void update(int r, int c, String value){
        Box box = chart[r][c];

        if(box==null){
            chart[r][c] = new Box( value );
            return;
        }
        chart[r][c].str = value;
    }

    public static void update(String prev, String value){
        for(int i = 0 ; i<50; i++){
            for(int j = 0 ; j<50; j++){
                Box box = chart[i][j];
                if(box==null || box.str==null){
                    continue;
                }else {
                    if(box.str.equals(prev)){
                        box.str = value;
                    }
                }
            }
        }
    }

    public static void merge(int r1, int c1, int r2, int c2){
        Box parent = chart[r1][c1];
        Box child = chart[r2][c2];

        Box box = null;

        if(parent==null && child==null){
            box = new Box();
            chart[r1][c1] = box;
            chart[r2][c2] = parent;
            return;
        }

        if(parent == null && child != null){
            chart[r1][c1] = child;
            return;
        }

        if(parent != null && child == null){
            chart[r2][c2] = parent;
            return;
        }

        if(parent.str == null && child.str != null ){
            box = child;
        }else{
            box = parent;
        }

        for(int i = 0 ; i<50; i++){
            for(int j = 0 ; j<50; j++){
                if(chart[i][j] == child || chart[i][j] == parent){
                    chart[i][j] = box;
                }
            }
        }
    }

    public static void unMerge(int r, int c){
        if(chart[r][c]==null){
            return;
        }
        Box box = chart[r][c];
        for(int i = 0 ; i<50; i++){
            for(int j = 0 ; j<50; j++){
                if(!(i==r && c==j) && chart[i][j] == box){
                    chart[i][j] = new Box();
                }
            }
        }
    }

    public static void print(int r, int c){
        if(chart[r][c]==null){
            answerList.add("EMPTY");
            return;
        }
        answerList.add(chart[r][c].str);
    }
}

class Box{
    String str = null;
    Box(){}
    Box(String str){
        this.str = str;
    }
}
