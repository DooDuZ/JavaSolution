package solution.levelTest.level9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

public class test9_5_1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<>();
		int[] arr = new int[T];
		int sum = 0;
		int max = 0;
		int min = 0;
		
		for(int i = 0 ; i<T ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}else {
				map.put(arr[i], 1);
			}
			sum+=arr[i];
			if(i==0) {
				max = arr[i];
				min = arr[i];
			}else {
				if(max<arr[i]) {
					max = arr[i];
				}
				if(min>arr[i]) {
					min = arr[i];
				}
			}
		}
		Arrays.sort(arr);
		
		ArrayList<Integer> list = new ArrayList<>();

		int mode = arr[0];
		for(int tmp : map.keySet()) {
			if(map.get(tmp)>map.get(mode)) {
				list.clear();
				mode = tmp;
				list.add(tmp);
			}else if(map.get(tmp)==map.get(mode)){
				list.add(tmp);
			}			
		}
		
		if(list.size()>1) {
			Collections.sort(list);
			mode = list.get(1);
		}
		
		System.out.println(Math.round((double) sum / T));
		System.out.println(arr[T/2]);
		System.out.println(mode);
		System.out.println(max-min);		
	}
}
