package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class test2239 {

    static ArrayList<Group> groupList = new ArrayList<>();
    static Cell[][] cells = new Cell[9][9];
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i<9; i++){
            groupList.add(new Group(i));
        }

        for( int i = 0 ; i<9; i++){
            String line = br.readLine();
            for(int j = 0; j<9; j++){
                Group group = groupList.get(setGroup(i,j));
                Cell cell = new Cell( line.charAt(j)-'0', group );
                if(line.charAt(j)-'0'==0){
                    count++;
                }
                cells[i][j] = cell;
                group.cellList.add(cell);
            }
        }

        dfs(0, 0);
    }


    public static void dfs(int row, int col){
        if(col==9){
            dfs(row+1, 0);
            return;
        }
        if(row==9){
            for(int i = 0 ; i<9; i++){
                for( int j = 0; j<9; j++){
                    sb.append(cells[i][j].value);
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            System.exit(0);
        }

        Cell cell = cells[row][col];
        if(cell.value!=0){
            dfs(row, col+1);
            return;
        }

        for(int k = 1; k<=9; k++){
            if(isPossible(k, row, col)){
                cell.value = k;
                dfs(row, col+1);
                cell.value = 0;
            }
        }
    }

    public static boolean isPossible(int value, int row, int col){
        Group group = cells[row][col].group;
        for(int i = 0 ; i<9; i++){
            // 행, 열, 소속 그룹 검사
            if(cells[row][i].value == value || cells[i][col].value == value || group.cellList.get(i).value == value){
                return false;
            }
        }
        return true;
    }

    public static int setGroup(int i, int j){
        int ret;
        if(i<3){
            if(j<3){ ret = 0; }
            else if(j<6){ ret = 1; }
            else{ ret = 2; }
        }else if(i<6){
            if(j<3){ ret = 3; }
            else if(j<6){ ret = 4; }
            else{ ret = 5; }
        }else{
            if(j<3){ ret = 6; }
            else if(j<6){ ret = 7; }
            else{ ret = 8; }
        }
        return ret;
    }
}

class Cell{
    int value;
    Group group;
    Cell(int value, Group group){
        this.value = value;
        this.group = group;
    }
}

class Group{
    int idx;
    ArrayList<Cell> cellList = new ArrayList<>();
    Group(int idx){
        this.idx = idx;
    }
}