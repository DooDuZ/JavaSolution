package solution.levelTest.level7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test7_2 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String s= br.readLine();
			int x = Integer.parseInt(s);
			
			int length = 1;
			int count = 1;
			
			while(true) {
				if(count>=x) {
					System.out.println(length);
					break;
				}
				length++;
				count += 6*(length-1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
