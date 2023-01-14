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

        maxHeap heap = new maxHeap();
        for(int i = 0 ; i<T; i++){
            int value = Integer.parseInt(br.readLine());
            if(value==0){
                sb.append(heap.pop()).append("\n");
            }else{
                heap.add(value);
            }
        }
        System.out.println(sb);
    }
}

class maxHeap {
    ArrayList<Integer> list = new ArrayList<>();
    maxHeap(){
        list.add(0);
    }

    void add(int value){
        list.add(value);
        int index = list.size()-1;
        while(true){
            int parent = list.get(index/2);
            if(parent < 1 || value<parent){
                break;
            }
            list.set(index, parent);
            list.set(index/2, value);
            index /= 2;
        }
    }
    int pop(){
        if(list.size()==1){
            return 0;
        }
        int pop = list.get(1);
        int last = list.get(list.size()-1);

        list.set(1, last);
        list.remove(list.size()-1);

        int index = 1;

        while(true){
            if(index*2>list.size()-1 || list.get(index*2)<list.get(index)){
                break;
            }
            int parent = list.get(index);
            int child = list.get(index*2);
            if(index*2+1<list.size()-1){
                child = Math.max(list.get(index*2+1), child);
            }
            list.set(index, child);
            list.set(index*2, parent);
            index *= 2;
        }
        return pop;
    }

    int peek(){
        return list.get(1);
    }
}