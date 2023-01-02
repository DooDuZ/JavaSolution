package solution.classTest.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class test10828 {
	
	ArrayList<Integer> list = new ArrayList<>();
	
	static test10828 test = new test10828();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		 
		/**/
		for(int i = 0 ; i<T; i++) {
			String command = br.readLine();
			
			if(command.equals("pop")) {
				sb.append(test.pop()).append('\n');  
			}else if(command.equals("size")) {
				sb.append(test.size()).append('\n');
			}else if(command.equals("empty")) {
				sb.append(test.empty()).append('\n');
			}else if(command.equals("top")) {
				sb.append(test.top()).append('\n');
			}else if(command.split(" ")[0].equals("push")) {
				int a = Integer.parseInt(command.split(" ")[1]);
				test.push(a);
			}		
		}		
		System.out.println(sb);
		
	}
	
	public void push(int a) {
		list.add(a);
	}
	
	public int pop() {
		if(list.size()==0) {
			return -1;
		}
		int a = list.get(list.size()-1);		
		list.remove(list.size()-1);
		return a;
	}
	
	public int size() {
		return list.size();
	}
	
	public int empty() {
		if(list.size()==0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public int top() {
		if(list.size()==0) {
			return -1;
		}
		return list.get(list.size()-1);
	}
}
