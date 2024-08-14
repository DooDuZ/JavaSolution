package solution.programmers;

import java.util.Arrays;
import java.util.Stack;

public class FindLargerNumber {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Arrays.fill(answer, -1);

        Stack<Integer[]> stack = new Stack<>();

        for(int i = 0 ; i<numbers.length; i++){
            while(!stack.isEmpty() && stack.peek()[0] < numbers[i] ){
                Integer[] cur = stack.pop();

                answer[cur[1]] = numbers[i];
            }

            stack.push(new Integer[]{numbers[i], i});
        }

        return answer;
    }
}
