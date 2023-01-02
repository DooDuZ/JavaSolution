package solution.levelTest.level15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class test15_11_1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int sum = 1;
		int count = 0;
		for(int i = 2; i<=N ; i++) {
			if(N<5) {
				System.out.println(0);
				break;
			}
			sum *= i;
			
			int[] arr = new int[2];

			arr = deleteZero(sum);
			
			count += arr[0];
			sum = arr[1];
		}		
		System.out.println(count);
	}
	
	static public int[] deleteZero(int sum) {
		int[] arr = new int[2];
		String cutzero = String.valueOf(sum);
		
		for(int i = cutzero.length()-1 ; i>=0; i--) {
			if(cutzero.charAt(i) != '0') {
				arr[0] = cutzero.length() - i - 1;
				
				String nums = "";
				if(i-3>=0) {
					nums += cutzero.charAt(i-3);
				}			
				if(i-2>=0) {
					nums += cutzero.charAt(i-2);
				}				
				if(i-1>=0) {
					nums += cutzero.charAt(i-1);
				}
				nums += cutzero.charAt(i);
				
				arr[1] = Integer.parseInt(nums);
				break;
			}
		}		
		return arr;
	}
}
