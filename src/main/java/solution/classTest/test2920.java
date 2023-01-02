package solution.classTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class test2920 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int[] arr = new int[8];
		
		for(int i = 0 ; i<8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int gap = arr[0]-arr[1];
		boolean check = true;
		for(int i = 0 ; i<7; i++) {
			if(gap!=arr[i]-arr[i+1]) {
				check = false;
			}
		}
		
		if(check) {
			if(gap==1) {
				System.out.println("descending");
			}else {
				System.out.println("ascending");
			}
		}else {
			System.out.println("mixed");
		}		
	}
}
