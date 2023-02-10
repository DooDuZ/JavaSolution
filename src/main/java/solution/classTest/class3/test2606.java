package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class test2606 {

    static ArrayList<cNode> list = new ArrayList<>();
    static LinkedList<cNode> queue = new LinkedList<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int link = Integer.parseInt(br.readLine());

        list.add(null);

        for(int i = 1 ; i<=N; i++){
            list.add(new cNode(i));
        }

        StringTokenizer st;
        for(int i = 1 ; i<=link; i++){
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            list.get(c1).computerList.add(list.get(c2));
            list.get(c2).computerList.add(list.get(c1));
        }

        queue.add(list.get(1));
        list.get(1).visited = true;

        bfs();

        System.out.println(count-1); // 1번 컴퓨터 제외이므로 -1
    }

    public static void bfs(){
        if(queue.isEmpty()){
            return;
        }
        count++;
        cNode current = queue.pop();

        for(cNode computer : current.computerList){
            if(!computer.visited){
                computer.visited = true;
                queue.add(computer);
            }
        }

        bfs();
    }
}

class cNode{
    int index;
    List<cNode> computerList = new ArrayList<>();
    boolean visited = false;

    cNode(int index){
        this.index = index;
    }

    @Override
    public String toString() {
        return String.valueOf(this.index);
    }
}