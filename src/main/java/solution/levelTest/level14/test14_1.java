package solution.levelTest.level14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class test14_1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int width = w-x;
		int height = h-y;
		int width2 = x;
		int height2 = y;
		
		int[] arr = {width, width2, height, height2};
		Arrays.sort(arr);
		
		System.out.println(arr[0]);		
	}
}
