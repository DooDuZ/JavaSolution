package solution.programmers;

import java.util.*;

public class Kakao2019_Muzi {

    public static void main(String[] args) {
        int[] food_times = {4,2,3,6,7,1,5,8};
        long k = 16;

        System.out.println(solution(k, food_times));
    }

    public static int solution(long k, int[] food_times){
        int length = food_times.length;

        if( k<length ){
            return (int)k+1;
        }

        LinkedList<Food> queue = new LinkedList<>();

        for(int i = 0; i<length; i++){
            queue.add( new Food ( i+1, food_times[i] ) );
        }

        Collections.sort(queue, (e1, e2)->{
            return e1.cost-e2.cost;
        });

        long rest = 0;
        long count = 0;
        long totalFoods = 0;
        while(!queue.isEmpty()){
            Food food = queue.peek();

            if(food.cost==0){
                queue.pop();
                continue;
            }
            long restTime = k-count;

            if( restTime < queue.size() * (food.cost-totalFoods)){
                rest = (int)((restTime) % queue.size());
                break;
            }else{
                count += queue.size() * (food.cost-totalFoods);
                totalFoods += food.cost-totalFoods;
                queue.pop();
            }
        }

        if (queue.isEmpty()){
            return -1;
        }

        Collections.sort(queue, (e1,e2)->{
            return e1.index - e2.index;
        });

        return queue.get((int) rest).index;
    }
}

class Food {
    int index;
    int cost;

    Food(int index, int cost){
        this.index = index;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "["+index + "," + cost +"]";
    }
}
