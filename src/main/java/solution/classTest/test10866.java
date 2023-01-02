package solution.classTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class test10866 {
	
	ArrayList<Integer> Deque = new ArrayList<>();
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		test10866 test = new test10866();
		
		for(int i = 0 ; i<T; i++) {
			String command = br.readLine();
			
			if(command.split(" ").length==1) {
				if(command.equals("pop_front")) {
					sb.append(test.pop_front()).append('\n');
				}else if(command.equals("pop_back")){
					sb.append(test.pop_back()).append('\n');
				}else if(command.equals("size")) {
					sb.append(test.size()).append('\n');
				}else if(command.equals("empty")) {
					sb.append(test.empty()).append('\n');
				}else if(command.equals("front")) {
					sb.append(test.front()).append('\n');
				}else if(command.equals("back")) {
					sb.append(test.back()).append('\n');
				}
			}else if(command.split(" ").length==2){
				if(command.split(" ")[0].equals("push_front")) {
					test.push_front(Integer.parseInt(command.split(" ")[1]));
				}else if(command.split(" ")[0].equals("push_back")) {
					test.push_back(Integer.parseInt(command.split(" ")[1]));
				}
			}
		}
		System.out.println(sb);
	}
	
	public void push_front(int X) {
		Deque.add(0, X);
	}
	
	public void push_back(int X) {
		Deque.add(X);
	}
	
	public int pop_front() {
		if(Deque.size()==0) {
			return -1;
		}else {
			int a = Deque.get(0);
			Deque.remove(0);
			return a;
		}		
	}
	
	public int pop_back() {
		if(Deque.size()==0) {
			return -1;
		}else {
			int a = Deque.get(Deque.size()-1);
			Deque.remove(Deque.size()-1);
			return a;
		}		
	}
	
	public int size() {
		return Deque.size();
	}
	
	public int empty() {
		if(Deque.size()==0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public int front() {
		if(Deque.size()==0) {
			return -1;
		}else {
			return Deque.get(0);
		}		
	}
	
	public int back() {
		if(Deque.size()==0) {
			return -1;
		}else {
			return Deque.get(Deque.size()-1);
		}		
	}
}
