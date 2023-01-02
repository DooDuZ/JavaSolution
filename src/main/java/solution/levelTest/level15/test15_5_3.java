package solution.levelTest.level15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class test15_5_3 {
	public static void main(String[] args) throws IOException{
		test15_5_3 test = new test15_5_3();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];
		for(int i = 0 ; i<T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		ArrayList<Integer> answerlist = new ArrayList<>();
		while(arr[0]!=0) {
			boolean check = true;
			for(int i = 1 ; i<T; i++) {
				if(test.commondivisor(arr[0], arr[i])==1) {
					check = false;
					break;
				}
			}
			if(!check) {
				for(int i = 0 ; i<arr.length; i++) {
					arr[i]--;
				}
				continue;
			}
			ArrayList<Integer> list = new ArrayList<>();			
			boolean[] checkMultiple = new boolean[arr[0]+1];
			checkMultiple[0] = true;
			checkMultiple[1] = true;
			for(int i= 2 ; i<=test.commondivisor(arr[0], arr[1]); i++) {
				if(arr[0]%i!=0) {
					for(int j = i; j<checkMultiple.length; j+=i) {
						checkMultiple[j] = true;
					}
				}else {
					list.add(i);
				}
			}
					
			for(int i=0; i<list.size(); i++) {
				boolean checkDivisor = true;
				for(int j = 0 ; j<arr.length; j++) {
					if(arr[j]%list.get(i)!=0) {
						checkDivisor = false;
						break;
					}
				}
				if(checkDivisor && !answerlist.contains(list.get(i))) {
					answerlist.add(list.get(i));
				}
			}			
			for(int i = 0 ; i<arr.length; i++) {
				arr[i]--;
			}
		}		
		Collections.sort(answerlist);		
		for(int i = 0 ; i<answerlist.size(); i++) {
			sb.append(answerlist.get(i)).append(' ');
		}		
		System.out.println(sb);
	}
	
	public int commondivisor(int a, int b) {
		int rest = a%b;
		a = b;
		b = rest;		
		if(rest==0) {
			return a;
		}		
		return commondivisor(a,b);		
	}
}

/*
	5
	5
	17
	23
	14
	83
*/