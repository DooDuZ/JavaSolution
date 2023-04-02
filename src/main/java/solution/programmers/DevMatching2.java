package solution.programmers;
import java.util.*;

public class DevMatching2 {

    public static void main(String[] args) {
        DevMatching2 dev = new DevMatching2();

        int[][] phone = { {1,1,1}, {1,1,1}, {1,1,1}, {1,1,1} };

        System.out.println(dev.solution(phone));
    }
    boolean[][] visited = new boolean[4][3];
    int[][] phone;
    int answer = 0;
    int buttons = 0;

    public int solution(int[][] phone) {
        this.phone = phone;

        for(int i = 0 ; i<4; i++){
            for(int j = 0 ; j<3; j++){
                if(phone[i][j]==1){
                    buttons++;
                }
            }
        }

        for(int i = 0 ; i<4; i++){
            for(int j = 0 ; j<3; j++){
                if(phone[i][j]==1){
                    visited[i][j] = true;
                    dfs(0,i,j);
                    visited[i][j] = false;
                }
                //System.out.println("현재 개수 : " + answer);
            }
        }

        return answer;
    }

    public void dfs(int depth, int row, int col){
        //System.out.println(depth + ", " + row +", "+ col);
        if(depth>0){
            answer++;
        }
        //위쪽 버튼
        if(row-1>=0 && !visited[row-1][col] && phone[row-1][col]==1){
            //System.out.println(1);
            visited[row-1][col] = true;
            dfs(depth+1,row-1,col);
            visited[row-1][col] = false;
        }
        if(row-1>=0 && col-1>=0 && !visited[row-1][col-1] && phone[row-1][col-1]==1){
            //System.out.println(2);
            visited[row-1][col-1] = true;
            dfs(depth+1, row-1,col-1);
            visited[row-1][col-1] = false;
        }
        if(row-1>=0 && col+1<3 && !visited[row-1][col+1] && phone[row-1][col+1]==1){
            //System.out.println(3);
            visited[row-1][col+1] = true;
            dfs(depth+1,row-1,col+1);
            visited[row-1][col+1] = false;
        }
        // 좌우 버튼
        if(col-1>=0 && !visited[row][col-1] && phone[row][col-1]==1){
            //System.out.println(4);
            visited[row][col-1] = true;
            dfs(depth+1, row,col-1);
            visited[row][col-1] = false;
        }
        if(col+1<3 && !visited[row][col+1] && phone[row][col+1]==1){
            //System.out.println(5);
            visited[row][col+1] = true;
            dfs(depth+1, row,col+1);
            visited[row][col+1] = false;
        }
        // 하단 버튼
        if(row+1<4 && col-1>=0 && !visited[row+1][col-1] && phone[row+1][col-1]==1){
            //System.out.println(6);
            visited[row+1][col-1] = true;
            dfs(depth+1, row+1,col-1);
            visited[row+1][col-1] = false;
        }
        if(row+1<4 && !visited[row+1][col] && phone[row+1][col]==1){
            //System.out.println(7);
            visited[row+1][col] = true;
            dfs(depth+1, row+1,col);
            visited[row+1][col] = false;
        }
        if(row+1<4 && col+1<3 && !visited[row+1][col+1] && phone[row+1][col+1]==1){
            //System.out.println(8);
            visited[row+1][col+1] = true;
            dfs(depth+1, row+1,col+1);
            visited[row+1][col+1] = false;
        }
    }
}