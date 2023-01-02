package solution.classTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class test10773 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		int sum = 0;
		
		for(int i = 0 ; i<T; i++) {
			int a = Integer.parseInt(br.readLine());
			
			if(a==0 && !stack.isEmpty()) {
				sum -= stack.pop();	
			}else {
				stack.push(a);
				sum += a;
			}	
		}		
		
		System.out.println(sum);		
	}
}
