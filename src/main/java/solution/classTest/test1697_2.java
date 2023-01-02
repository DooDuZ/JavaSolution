package solution.classTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// bfs 첫 시도

public class test1697_2 {
	static int N;
	static int K;
	static LinkedList<Integer> list = new LinkedList<>();
	static boolean[] arr = new boolean[100000];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list.add(N);
		
		search(0);
	}
	
	public static void search(int count) {
		int nodeValue = list.pop();
		if(arr[nodeValue]) {
			return;
		}
		
		if(nodeValue == K) {
			System.out.println(count);
			return;
		}
		arr[count] = true;
		count++;
		
		if(nodeValue-1==K) {
			System.out.println(count);
			return;
		}
		list.add(nodeValue-1);
		
		if(nodeValue+1==K) {
			System.out.println(count);
			return;
		}
		list.add(nodeValue+1);
		
		
		if(nodeValue*2==K) {
			System.out.println(count);
			return;
		}
		list.add(nodeValue*2);
		
		search(count, nodeValue+1, nodeValue-1, nodeValue*2);
	}
	
	public static void search(int count, int case1, int case2, int case3) {
		int nodeValue = list.pop();
		System.out.println(nodeValue);
		if(arr[nodeValue]) {
			System.out.println("test");
			return;
		}
		
		if(nodeValue == K) {
			System.out.println(count);
			return;
		}
		arr[count] = true;
		count++;
		
		if(nodeValue-1==K) {
			System.out.println(count);
			return;
		}
		list.add(nodeValue-1);
		
		if(nodeValue+1==K) {
			System.out.println(count);
			return;
		}
		list.add(nodeValue+1);
		
		
		if(nodeValue*2==K) {
			System.out.println(count);
			return;
		}
		if(nodeValue*2<=100000) {
			list.add(nodeValue*2);
		}		
		
		search(count, nodeValue+1, nodeValue-1, nodeValue*2);
	}	
}
