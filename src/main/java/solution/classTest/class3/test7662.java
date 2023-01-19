package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class test7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        DoubleHeap maxHeap;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int row = Integer.parseInt(br.readLine());
            maxHeap = new DoubleHeap();
            for (int j = 0; j < row; j++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int value = Integer.parseInt(st.nextToken());
                if (command.equals("I")) {
                    maxHeap.add(value);
                } else {
                    if (maxHeap.isEmpty()) {
                        continue;
                    }
                    if (value == 1) {
                        if (maxHeap.size() != 0) {
                            maxHeap.pop();
                        }
                    } else {
                        if (maxHeap.size() != 0) {
                            maxHeap.popLast();
                        }
                    }
                }
            }
            if (maxHeap.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(maxHeap.peek()).append(" ").append(maxHeap.popLast()).append("\n");
            }
            System.out.println(maxHeap.list.toString());
        }
        System.out.println(sb);
    }
}
class DoubleHeap{
    ArrayList<Integer> list = new ArrayList<>();
    DoubleHeap(){
        list.add(0);
    }
    void add(int num){
        list.add(num);
        int index = list.size()-1;
        while(index>1 && list.get(index/2)<num){
            int parent = list.get(index/2);
            list.set(index, parent);
            list.set(index/2, num);
            index /= 2;
        }
        System.out.println(list.toString());
    }
    int pop(){
        int max = list.get(1);
        int value = list.get(list.size()-1);
        list.set(1, value);
        list.remove(list.size()-1);

        int index = 1;
        while(index<list.size()-1){
            if(index*2>=list.size()-1){ break; }
            int child = list.get(index*2);
            int childIndex = index*2;
            if(index*2+1<list.size()-1){
                if(child<list.get(index*2+1)){
                    child = list.get(index*2+1);
                    childIndex = index*2+1;
                }
            }
            if(value<child){
                list.set(childIndex, value);
                list.set(index, child);
                index = childIndex;
            }else{
                break;
            }
        }
        System.out.println(list.toString());
        return max;
    }

    int peek(){
        return list.get(1);
    }

    int popLast(){
        int min = list.get(list.size()-1);
        list.remove(list.size()-1);
        System.out.println(list.toString());
        return min;
    }

    boolean isEmpty(){
        if(list.size()==1){
            return true;
        }
        return false;
    }

    int size(){
        return list.size()-1;
    }
}
