package solution.levelTest.level11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test11_6 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		
		sb.append((int)(Math.pow(2, N)-1)).append("\n");
		repeat(N, 1, 3, 2);
		
		System.out.println(sb);
		
	}
	
	public static void repeat(int N, int start, int goal, int replace) {
		if(N==1) {
			sb.append(start + " " + goal).append("\n");
			return;
		}
		repeat(N-1, start, replace, goal);
		sb.append(start+" "+goal).append("\n");
		
		repeat(N-1, replace, goal, start);
	}	
}

/*
 	1 - 3,1
 	2 - 2,1 3,2	3,1
 	3 - 3,1 2,2 2,1 3,3 1,1 3,2 3,1
 	4 - 2,1 3,2 3,1 2,3 1,1 2,2 2,1 3,4 3,1 1,2 1,1 3,3 2,1 3,2 3,1
 	5 - 3,1 2,2 2,1 3,3 1,1 3,2 3,1 2,4 2,1 1,2 1,1 2,3 3,1 2,2 2,1 3,5 3,1 1,2 1,1 3,3 
 
*/