package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class test11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        MaxHeap heap = new MaxHeap();
        for(int i = 0 ; i<T; i++){
            int value = Integer.parseInt(br.readLine());
            if(value==0){
                int pop = 0;
                if(!heap.isEmpty()){ pop = heap.pop();}
                sb.append(pop).append("\n");
            }else{
                heap.add(value);
            }
        }
        System.out.println(sb);
    }
}

class MaxHeap{
    ArrayList<Integer> list = new ArrayList<>();
    MaxHeap(){
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
    }

    int pop(){
        int max = list.get(1);
        int value = list.get(list.size()-1);
        list.set(1, value);
        list.remove(list.size()-1);

        int index = 1;
        while(index<list.size()-1){
            if(index*2>list.size()-1){ break; }
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
    boolean isEmpty(){
        if(list.size()==1){
            return true;
        }
        return false;
    }
}

/*
8
100
50
75
1
2
51
0
0

9
1
2
3
4
0
0
0
0
0
 */