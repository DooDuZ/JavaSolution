package solution.levelTest.level11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class test11_4 {
	static int[] sorted = null;
	static int counter = 0;
	static int index;
	static int answer = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		index = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		new test11_4().merge_sort(arr);
		
		System.out.println(answer);
	}
	
	public void merge_sort(int[] arr) {
		sorted = new int[arr.length];
		merge_sort(arr, 0, arr.length-1);
		sorted = null;
	}
	
	public void merge_sort(int[] arr, int l, int r) {
		int m = (l+r)/2;
		if(l==r) {
			return;
		}
		merge_sort(arr,l,m);
		merge_sort(arr,m+1,r);
		
		merge(arr,l, m,r);
	}
	
	public void merge(int[] arr, int l , int m, int r) {
		int left = l;
		int right = m+1;
		int count = l;
		
		while(left <= m && right<=r) { 
			if(arr[left]<=arr[right]) {
				sorted[count] = arr[left];
				left++;
				count++;
				counter++;
				if(counter==index) {
					answer = arr[left-1];
				}
			}else if(arr[left]>=arr[right]){
				sorted[count] = arr[right];
				right++;
				count++;
				counter++;
				if(counter==index) {
					answer = arr[right-1];
				}
			}
		}
		
		if(left>m) {
			while(right<=r) {
				sorted[count] = arr[right];
				count++;
				right++;
				counter++;
				if(counter==index) {
					answer = arr[right-1];
				}
			}
		}else if(right>r){
			while(left<=m) {
				sorted[count] = arr[left];
				count++;
				left++;
				counter++;
				if(counter==index) {
					answer = arr[left-1];
				}
			}
		}
		for(int i = l; i<=r; i++) {
			arr[i] = sorted[i];
		}
	}
}
