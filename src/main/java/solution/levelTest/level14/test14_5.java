package solution.levelTest.level14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class test14_5 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int r = Integer.parseInt(br.readLine());
		
		System.out.println(r*r*Math.PI);
		System.out.println(r*r+r*r);		
	}
}
