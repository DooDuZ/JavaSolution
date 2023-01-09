package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1992 {

    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int side = Integer.parseInt(br.readLine());

        board = new int[side][side];

        for(int i = 0 ; i<side; i++){
            String str = br.readLine();
            for(int j = 0 ; j<side; j++){
                board[i][j] = str.charAt(j)-'0';
            }
        }
        System.out.println(checkType(0, side-1, 0, side-1));
    }

    public static String checkType(int startX, int endX, int startY, int endY){
        if(startX == endX && startY == endY){
            return String.valueOf(board[startY][startX]);
        }

        int midX = (startX+endX)/2;
        int midY = (startY+endY)/2;

        String first = checkType(startX, midX, startY, midY);
        String second = checkType(midX+1, endX, startY, midY);
        String third = checkType(startX, midX, midY+1, endY);
        String fourth = checkType(midX+1, endX, midY+1, endY);

        String answer;

        if( ( first.equals("0") || first.equals("1") ) && first.equals(second) && first.equals(third) && first.equals(fourth)){
            answer = first;
        }else{
            answer = "("+first+second+third+fourth+")";
        }
        return answer;
    }
}
