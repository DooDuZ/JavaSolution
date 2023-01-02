package solution.levelTest.level15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.IOException;

// 시간초과
	// 반복문 너무 많음

public class test15_5_1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int[] arr = new int[T];
		
		for(int i = 0 ; i<T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		// 모든 수에 -x를 한 뒤, 공약수가 있다면 sb.append(x).append('\n')
		int count = 0;
		ArrayList<Integer> answer = new ArrayList<>();
		
		while(count!=arr[0]) {						
			int min = arr[0]-count;
			ArrayList<Integer> list = new ArrayList<>();
			
			int divisor = 2;
			
			while(true) {			
				if(min%divisor==0) {
					min /= divisor;
					if(!list.contains(divisor)) {
						list.add(divisor);
					}									
				}else {
					divisor++;
				}			
				if(min==1) {
					break;
				}
			}
			list.add(arr[0]-count);
			
			for(int i = 0 ; i<list.size(); i++) {
				boolean check = true;
				for(int j = 0; j<arr.length; j++) {
					if((arr[j]-count)%list.get(i)!=0) {
						check = false;
						break;
					}
				}
				if(check) {
					if(!answer.contains(list.get(i))) {
						answer.add(list.get(i));
					}					
				}
			}
			count++;
		}
		
		Collections.sort(answer);
		
		for(int i = 0 ; i<answer.size(); i++) {
			if(answer.get(i)!=1) {
				sb.append(answer.get(i)).append(' ');
			}
		}
		System.out.println(sb);		
	}
}
