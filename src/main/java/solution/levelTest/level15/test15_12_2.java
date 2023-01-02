package solution.levelTest.level15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class test15_12_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = a-b;
		
		int five = checkIndex(5,a) - checkIndex(5,b) - checkIndex(5,c);
		int two = checkIndex(2,a) - checkIndex(2,b) - checkIndex(2,c);
		
		System.out.println(five);	
	}
	
	static public int checkIndex(int index ,int num ) {
		int count = 0;
		
		while(num!=0) {
			count += num/index;
			num /= index;
		}
		
		return count;
	}
}
