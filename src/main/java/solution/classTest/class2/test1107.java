package solution.classTest.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class test1107 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int goal = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> buttons = new ArrayList<>();
		
		for(int i = 0 ; i<10; i++) {
			buttons.add(i);
		}
		
		if(N!=0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i<N; i++) {
				buttons.remove( buttons.indexOf(Integer.parseInt(st.nextToken())));
			}
		}		

		int max = 0;
		int min = 0;
		if(goal>100) {
			for(int i = goal ; i < 1000000; i++) {
				 String str = String.valueOf(i);
				 boolean check = true;
				 for(int j = 0; j<str.length(); j++) {
					 if(!buttons.contains(str.charAt(j)-'0')) {
						 check = false;
						 break;
					 }		 
				 }
				 if(check) {
					 max = i;
					 break;
				 }
			}
			for(int i = goal; i>=100; i--) {
				String str = String.valueOf(i);
				 boolean check = true;
				 for(int j = 0; j<str.length(); j++) {
					 if(!buttons.contains(str.charAt(j)-'0')) {
						 check = false;
						 break;
					 }		 
				 }
				 if(check) {
					 min = i;
					 break;
				 }				
			}
		}else if(goal<100){
			for(int i = goal ; i <= 100; i++) {
				 String str = String.valueOf(i);
				 boolean check = true;
				 for(int j = 0; j<str.length(); j++) {
					 if(!buttons.contains(str.charAt(j)-'0')) {
						 check = false;
						 break;
					 }		 
				 }
				 if(check) {
					 max = i;
					 break;
				 }
			}
			for(int i = goal; i>=0; i--) {
				String str = String.valueOf(i);
				 boolean check = true;
				 for(int j = 0; j<str.length(); j++) {
					 if(!buttons.contains(str.charAt(j)-'0')) {
						 check = false;
						 break;
					 }		 
				 }
				 if(check) {
					 min = i;
					 break;
				 }				
			}			
		}else {
			System.out.println(0);
			return;
		}
		
		if(Math.abs(100-max)>Math.abs(goal-min)) {
			System.out.println(Math.abs(goal-min)+String.valueOf(goal).length());
		}else {
			System.out.println(Math.abs(goal-max)+String.valueOf(goal).length());
		}	
	}
}

/*
99999
2
8 9
 */
