package solution.classTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test1697_3 {
	
	static int N;
	static int K;
	static boolean[] arr = new boolean[100001];
	static LinkedList<Integer[]> list = new LinkedList<>();
	int count = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Integer[] param = {N,0};
		arr[N] = true;
		list.add(param);		
		
		search();
	}
	
	public static void search() {
		Integer[] nodeData = list.pop();
		
		int nodeValue = nodeData[0];
		int depth = nodeData[1];
		
		if(nodeValue == K) {
			System.out.println(depth);
			return;
		}
		
		int plusValue = nodeValue+1;
		int minusValue = nodeValue-1;
		int doubleValue = nodeValue*2;
		
		depth++;
		
		if(plusValue==K) {
			System.out.println(depth);
			return;
		}else {
			if( plusValue<100001 && plusValue>=0 && !arr[plusValue] ) {
				Integer[] param = {plusValue, depth};
				list.add(param);
				arr[plusValue] = true;
			}
		}
		
		if(minusValue==K) {
			System.out.println(depth);
			return;
		}else {
			if( minusValue<100001 && minusValue>=0 && !arr[minusValue]) {
				Integer[] param = {minusValue, depth};
				list.add(param);
				arr[minusValue] = true;
			}
		}
		
		if(doubleValue==K) {
			System.out.println(depth);
			return;
		}else {
			if( doubleValue<100001 && doubleValue>=0 && !arr[doubleValue]) {
				Integer[] param = {doubleValue, depth};	
				list.add(param);
				arr[doubleValue] = true;
			}
		}		
		search();
	}
}
