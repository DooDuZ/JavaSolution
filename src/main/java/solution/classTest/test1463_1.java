package solution.classTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.IOException;


// 메모리 초과
	// list 빼야할듯
public class test1463_1 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		System.out.println(makeOne(X,0));
	}
	
	public static int makeOne( int X, int count) {		
		if(X<=1) {
			return count;
		}
		List<Integer> list = new ArrayList<>();
		if(X%6==0) {
			list.add(makeOne(X/3, count+1));
			list.add(makeOne(X/2, count+1));
			list.add(makeOne(X-1, count+1));
			return Collections.min(list);
		}else if(X%3==0) {
			list.add(makeOne(X-1, count+1));
			list.add(makeOne(X/3, count+1));						
			return Collections.min(list);
		}else if(X%2==0) {
			list.add(makeOne(X-1, count+1));
			list.add(makeOne(X/2, count+1));
			return Collections.min(list);
		}else {
			return makeOne(X-1, count+1);
		}
	}
}
