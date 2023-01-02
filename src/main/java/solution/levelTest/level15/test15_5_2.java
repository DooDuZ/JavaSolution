package solution.levelTest.level15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.io.IOException;

// 코드는 아주 조금 짧아졌지만 여전히 시간초과 
	// 로직 변경 필요

public class test15_5_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int[] arr = new int[T];
		
		for(int i = 0 ; i<T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		List<Integer> answers = new ArrayList<>();
		while(arr[0]!=0) {
			
			ArrayList<Integer> list = new ArrayList<>();
			for(int i = 2; i<=arr[0]; i++) {
				if(arr[0]%i==0) {
					list.add(i);
				}
			}
			
			for(int i = 0 ; i<list.size(); i++) {
				boolean check = true;
				for(int j = 0; j<arr.length; j++) {
					if(arr[j]%list.get(i)!=0) {
						check = false;
						break;
					}
				}
				if(check) {
					if(!answers.contains(list.get(i))) {
						answers.add(list.get(i));
					}					
				}
			}
			
			for(int i = 0 ; i<arr.length; i++) {
				arr[i]--;
			}
		}
		Collections.sort(answers);
		
		for(int i=0; i<answers.size(); i++) {
			sb.append(answers.get(i)).append(' ');
		}
		System.out.println(sb);
	}
}

/*
	5
	5
	17
	23
	14
	83
*/
