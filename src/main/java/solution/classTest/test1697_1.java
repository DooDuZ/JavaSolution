package solution.classTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test1697_1 {
	static int N;
	static int K;	
	static LinkedList<Integer> list = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list.add(N);
		
		System.out.println(search(0,0));
	}
	
	public static int search(int row, int col ) {
		
		int nodeValue = list.pop();
		
		if(nodeValue == K) {
			return row;
		}
		
		if(nodeValue-1==K) {
			return row+1;
		}
		list.add(nodeValue-1);
		
		if(nodeValue+1==K) {
			return row+1;
		}
		list.add(nodeValue+1);
		
		
		if(nodeValue*2==K) {
			return row+1;
		}
		list.add(nodeValue*2);		
		
		if(Math.pow(3, row)==col+1) {
			return search(row+1, 0);
		}else {
			return search(row, col+1);
		}
	}	
}