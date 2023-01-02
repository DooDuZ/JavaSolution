package solution.levelTest.level9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class test9_3 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int[] arr = new int[10001];
		
		for(int i = 0 ; i<T ; i++){
			arr[Integer.parseInt(br.readLine())]++;
		}
		
		br.close();
		
		for(int i = 0 ; i<10001; i++) {
			while(arr[i]>0) {
				sb.append(i).append("\n");
				arr[i]--;
			}
		}
		System.out.println(sb);
	}
}
/*
int[] arr = new int[T];
int count = 0;
while(st.hasMoreTokens()){
	arr[count] = Integer.parseInt(st.nextToken());
	count++;
}

int[] arr2 = new int[10001];
for(int i = 0 ; i<T ; i++) {
	arr2[arr[i]]++;
}
for(int i = 1 ; i<10001; i++) {
	arr2[i] = arr2[i]+arr2[i-1];
}		
int[] answer = new int[T];
for(int i = T-1 ; i>=0 ; i--) {
	answer[arr2[arr[i]]-1] = arr[i];
	arr2[arr[i]]--;
}
for(int i = 0 ; i<T;i++) {
	sb.append(answer[i]+"\n");
}
System.out.println(sb);
*/