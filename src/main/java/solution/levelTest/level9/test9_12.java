package solution.levelTest.level9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.IOException;

public class test9_12 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<T ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());			
		}
		int[] arr2 = arr.clone();
		
		Arrays.sort(arr2);
		Map<Integer, Integer> map = new HashMap<>();
		map.put(arr2[0], 0);
		int count = 1;
		for(int i = 1 ; i<T; i++) {
			if(arr2[i]!=arr2[i-1]) {
				map.put(arr2[i], count);
				count++;
			}
		}
		for(int i = 0; i<T; i++) {
			sb.append(map.get(arr[i])+" ");
		}
		System.out.println(sb);
	}
}

/*
		시간 초과 / 3~4N 복잡도
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];
		ArrayList<Integer> list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<T ; i++) {
			int a = Integer.parseInt(st.nextToken());
			arr[i] = a;
			if(!list.contains(a)) {
				list.add(a);
			}
		}
		Collections.sort(list);
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0 ; i<list.size() ; i++) {
			map.put(list.get(i), i);
		}
		for(int i = 0 ; i<T; i++) {
			sb.append(map.get(arr[i])+" ");
		}
		System.out.println(sb);


*/