package solution.levelTest.level15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class test15_12 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int count = 0;
		
		for(int i = 5; i<=a ; i+=5) {
			count += checkIndex(i);
		}
		
		for(int i = 5; i<=b ; i+=5) {
			count -= checkIndex(i);
		}
		
		for(int i = 5; i<=a-b ; i+=5) {
			count -= checkIndex(i);
		}
		
		System.out.println(count);
	}
	
	static public int checkIndex( int num ) {
		int answer = 0;
		if(num==0) {
			return 0;
		}
		
		while(num%5==0) {
			answer++;
			num /= 5;
		}
		
		return answer;
	}
}
