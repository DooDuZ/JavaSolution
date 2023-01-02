package solution.levelTest.level9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class test9_1 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];
		
		for(int i = 0 ; i<T ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0 ; i<T ; i++) {
			for(int j = i ; j<T ; j++) {
				if(arr[i]<arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		for(int tmp : arr) {
			System.out.println(tmp);
		}	
	}
}
