package solution.levelTest.level9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class test9_10 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		String[] arr = new String[T];
		
		for(int i = 0 ; i<T ; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, (el, el2)->{
			if(el.length() == el2.length()) {
				int answer = 0;
				for(int i = 0 ; i<el.length();i++) {
					if(el.charAt(i)-el2.charAt(i)!=0) {
						answer = el.charAt(i)-el2.charAt(i);
						break;
					}
				}
				return answer;
			}else {
				return el.length() - el2.length();
			}
		});

		for(int i = 0 ; i<arr.length ; i++) {
			if(i!=0 && arr[i].equals(arr[i-1])) {
				continue;
			}
			sb.append(arr[i]).append("\n");
		}		
		System.out.println(sb);
	}
}
