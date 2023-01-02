package solution.classTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class test10845 {
	
	ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		test10845 test = new test10845(); 
		
		for(int i = 0 ; i<T; i++) {
			String command = br.readLine();
			
			if(command.equals("pop")) {
				sb.append(test.pop()).append('\n');  
			}else if(command.equals("size")) {
				sb.append(test.size()).append('\n');
			}else if(command.equals("empty")) {
				sb.append(test.empty()).append('\n');
			}else if(command.equals("front")) {
				sb.append(test.front()).append('\n');
			}else if(command.equals("back")) {
				sb.append(test.back()).append('\n');
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
		int a = list.get(0);		
		list.remove(0);
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
	
	public int front() {
		if(list.size()==0) {
			return -1;
		}
		return list.get(0);
	}
	
	public int back() {
		if(list.size()==0) {
			return -1;
		}
		return list.get(list.size()-1);
	}
}
