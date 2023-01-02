package solution.levelTest.level11;

import java.util.Scanner;

public class test11_3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = input.nextInt();		
		for(int i = 0 ; i<T ; i++) {
			String s = input.next();
			int[] arr = new test11_3().isPalindrome(s);		
			sb.append(arr[0] +" "+ arr[1]+"\n");			
		}
		System.out.println(sb);
	}
	
	int[] recursion(String s, int l, int r, int count){
		count++;
		int[] answer = new int[2];
	    if(l >= r) {
	    	answer[0] = 1;
	    	answer[1] = count;
	    	return answer;
	    }
	    else if(s.charAt(l) != s.charAt(r)) {
	    	answer[0] = 0;
	    	answer[1] = count;
	    	return answer;
	    } 
	    else return recursion(s, l+1, r-1, count);
	}

	int[] isPalindrome(String s){
	    return recursion(s, 0, s.length()-1, 0);
	}
}


