package solution.classTest.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test9012 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i<N; i++) {
			String str = br.readLine();
			
			int left = 0;
			int right = 0;
			boolean check = true;
			
			for(int j=0 ; j<str.length(); j++) {
				if(str.charAt(0)!='(' || str.charAt(str.length()-1)!=')') {
					check = false;
					break;
				}				
				if(str.charAt(j)=='(') {
					left++;
				}else {
					right++;
				}
				
				if(right>left) {
					check = false;
					break;
				}
				
				if(j==str.length()-1) {
					if(left!=right) {
						check = false;
						break;
					}
				}
			}
			
			if(check) {
				sb.append("YES").append('\n');
			}else {
				sb.append("NO").append('\n');
			}
		}
		System.out.println(sb);
	}
}





/*
	 6
(())())
(((()())()
(()())((()))
((()()(()))(((())))()
()()()()(()()())()
(()((())()(
 * */