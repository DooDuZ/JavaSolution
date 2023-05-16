package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class test1918 {

    static Map<Character, Integer> priorityMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String operation = br.readLine();

        priorityMap.put( '+', 1 );
        priorityMap.put( '-', 1 );
        priorityMap.put( '*', 2 );
        priorityMap.put( '/', 2 );
        priorityMap.put( '(', 3 );
        priorityMap.put( ')', 3 );

        System.out.println(setPriority(operation));
    }


    public static String setPriority(String operation){
        StringBuilder op = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < operation.length(); i++){
            char numOrOperator = operation.charAt(i);

            if(numOrOperator==')'){
                while(stack.peek()!='('){
                    op.append(stack.pop());
                }
                stack.pop();
                continue;
            }

            if(!priorityMap.containsKey(numOrOperator)){
                op.append(numOrOperator);
                continue;
            }

            if(stack.isEmpty() || stack.peek()=='('){
                stack.push(numOrOperator);
                continue;
            }
            int cur = priorityMap.get(numOrOperator);
            int prev = priorityMap.get(stack.peek());

            if( prev < cur ){
                stack.push(numOrOperator);
            }else if(prev==cur){
                op.append(stack.pop());
                stack.push(numOrOperator);
            }else{
                while(!stack.isEmpty() && stack.peek()!='(' && stack.peek() >= cur){
                    op.append(stack.pop());
                }
                stack.push(numOrOperator);
            }
        }

        while(!stack.isEmpty()){
            op.append(stack.pop());
        }

        return op.toString();
    }
}
/*

A+B/C*D*(E*F+G)

ABC/D*EFG*+*+


ABC/D*EF*G+*+



A + B/CD(EF+G)


 */