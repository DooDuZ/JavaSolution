package solution.classTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class test4949 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = br.readLine();
			
			if(str.equals(".")) {
				break;
			}
			
			Stack<Character> stack = new Stack<>();
			
			boolean check = true;
			
			for(int i = 0 ; i<str.length(); i++) {
				
				char letter  = str.charAt(i);
				
				if(letter =='(' || letter =='[') {
					stack.push(letter);
				}else if(letter == ')') {
					if(stack.isEmpty() || stack.peek()!='(') {
						check = false;
					}else {
						stack.pop();
					}
				}else if(letter ==']') {
					if(stack.isEmpty() || stack.peek()!='[') {
						check = false;
					}else {
						stack.pop();
					}
				}
			}
			
			if(stack.isEmpty() && check) {
				sb.append("yes").append('\n');
			}else {
				sb.append("no").append('\n');
			}
		}
		System.out.println(sb);
	}
}
