package solution.levelTest.level9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;



/*
	각종 프레임워크 사용해서 풀긴 했으나...
	기본적으로 카운팅 솔트를 이용해서 풀고 싶은 마음이 큼
	근데 잘 안댐... 이해도 넘 낮은듯
	반드시 후에 다시 풀것!!!!
*/



public class test9_5_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[8001];
		int sum = 0;
		
		for(int i = 0 ; i<T ; i++) {
			int el = Integer.parseInt(st.nextToken());
			arr[el+4000]++;
			sum += el;
		}
		for(int i = 0; i<8001; i++) {
			if(i==0) {
				continue;
			}			
		}
		int[] sorted = new int[T];
		
		/*
		for(int i = 8000 ; i>=0 ; i--) {
			while(arr[i]!=0) {
				sorted[arr[i]]
			}
			
		}
		*/
		for(int tmp : sorted) {
			System.out.println(tmp);
		}
	}
}







