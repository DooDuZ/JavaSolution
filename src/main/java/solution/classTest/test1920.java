package solution.classTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1920 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		
		for(int i = 0 ; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = null;
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<M; i++) {
			int a = Integer.parseInt(st.nextToken());
			sb.append(indexOf(arr,a)).append('\n');
		}
		System.out.println(sb);		
	}
	public static int indexOf(int[] arr, int a) {
		for(int i = 0 ; i<arr.length; i++) {
			if(arr[i]==a) {
				return 1;
			}
		}
		return 0;		
	}
}
