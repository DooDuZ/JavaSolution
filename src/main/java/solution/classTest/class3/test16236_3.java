package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 디버깅 해도 뭐가 문제인지 모르겠음... 첨부터 다시 만들기
public class test16236_3 {

    static int N;
    static boolean[][] visited;
    static int[][] board;

    // 출발 위치를 표시할 좌표값
    static int row;
    static int col;

    // bfs에 사용할 queue
        // element마다 값, x좌표, y좌표, 걸린 시간이 필요
    static LinkedList<Integer[]> queue = new LinkedList<>();

    // 같은 거리의 셀을 저장할 리스트
    static ArrayList<Integer[]> eatAble = new ArrayList<>();

    // visited 종료시점까지 걸린 시간
    static int count = 0;

    // 상어의 크기
    static int sharkSize = 2;
    // 상어가 성장한 뒤 먹은 먹이의 개수
    static int feedCount = 0;

    // 상어가 최초 위치로부터 이동한 거리 [시간과 같음]
    static int distance = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        board = new int[N][N];

        StringTokenizer st;
        for(int i = 0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 9){
                    board[i][j] = 0;
                    row = i;
                    col = j;
                }
            }
        }

        queue.add(new Integer[]{board[row][col], row, col, 0});
        visited[row][col] = true;

        bfs();

        System.out.println(count);
    }

    public static void bfs(){
        if (queue.isEmpty()){
            if(!eatAble.isEmpty()){
                // 모든 위치 탐색 후에 eatAble에 값이 남아있는 경우
                feed();
            }
            return;
        }

        Integer[] arr = queue.pop();

        int fishSize = arr[0];
        int currentRow = arr[1];
        int currentCol = arr[2];
        int time = arr[3];

/*
        System.out.println("시작 좌표는" + currentRow + ", " + currentCol + " 입니다.");
        System.out.println("물고기의 크기는 " + fishSize + " 입니다.");
        System.out.println("새로운 탐색 시작 후 현재까지 걸린 시간은 " + time + " 입니다.");
*/

        if(distance<time){
            if(!eatAble.isEmpty()){
                feed();
                return;
            }
            distance = time;
        }

        if( fishSize!=0 && fishSize<sharkSize){
            // 현재 셀의 물고기가 먹을 수 있다면 먹이 목록에 추가
            // System.out.println(arr[0]+"크기의 물고기가 추가되었습니다.");
            eatAble.add(arr);
        }

        // 셀의 주변 셀을 검사 후 queue에 추가
        if(currentRow-1>=0 ) {
            if(!visited[currentRow-1][currentCol] && board[currentRow-1][currentCol]<=sharkSize){
                visited[currentRow-1][currentCol] = true;
                queue.add(new Integer[]{board[currentRow-1][currentCol], currentRow-1, currentCol, time+1});
            }
        }
        if(currentRow+1<N ){
            if(!visited[currentRow+1][currentCol] && board[currentRow+1][currentCol]<=sharkSize){
                visited[currentRow+1][currentCol] = true;
                queue.add(new Integer[]{board[currentRow+1][currentCol], currentRow+1, currentCol, time+1});
            }
        }
        if(currentCol-1>=0){
            if(!visited[currentRow][currentCol-1] && board[currentRow][currentCol-1]<=sharkSize ){
                visited[currentRow][currentCol-1] = true;
                queue.add(new Integer[]{board[currentRow][currentCol-1], currentRow, currentCol-1, time+1});
            }
        }
        if(currentCol+1<N){
            if(!visited[currentRow][currentCol+1] && board[currentRow][currentCol+1]<=sharkSize){
                visited[currentRow][currentCol+1] = true;
                queue.add(new Integer[]{board[currentRow][currentCol+1], currentRow, currentCol+1, time+1});
            }
        }
/*
        System.out.println();
        for(int i = 0 ; i<N; i++){
            for (int j = 0 ; j< N; j++){
                if(i==row && j==col){
                    System.out.print("9 ");
                }else if(visited[i][j]){
                    System.out.print("* ");
                }else {
                    System.out.print(board[i][j]+ " ");
                }
            }
            System.out.println();
        }
        System.out.println();
*/


        bfs();
    }

    public static void feed(){
        // 먹은 먹이 수 증가
        feedCount++;
        if(sharkSize==feedCount){
            sharkSize++;
            feedCount = 0;
        }

        // 먹이 목록에서 가장 위, 가장 왼쪽의 요소 추출하기

        Collections.sort(eatAble, (e1,e2)->{
            if(e1[1]==e2[1]){
                // 두 요소의 row값이 같으면 col의 값을 비교
                return e1[2]-e2[2];
            }
            // 두 요소의 row값을 비교
            return e1[1]-e2[1];
        });

        Integer[] cell = eatAble.get(0);

        // 밥 먹이기
        count += distance;

        // 시작점을 먹이의 위치로 변경
        row = cell[1];
        col = cell[2];

        // 먹은 물고기 제거
        cell[0] = 0;
        board[row][col] = 0;

        // 지난 시간 초기화
        cell[3] = 0;

        // 거리 초기화
        distance = 0;

        // 기존 queue와 eatAble을 비워준다.
        queue = new LinkedList<>();
        eatAble = new ArrayList<>();

        // 방문 목록을 초기화해준다.
        visited = new boolean[N][N];

        // 시작점 셀을 queue에 추가 후 해당 좌표의 방문값을 true로 바꿔준다.
        queue.add(cell);
        visited[row][col] = true;

        // 다시 탐색
        bfs();
    }
}
