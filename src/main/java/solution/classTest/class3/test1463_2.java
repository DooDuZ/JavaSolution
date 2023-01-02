package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


// 1463_1에서 list빼고 했더니 시간초과남
	// 동적계획법 추가
	// int 배열로 사용 시 arr[0] == arr[1] == 0
	// if(arr[X]==0) 여기서 계속 돌아버림
	// Integer배열 선언 후 arr[X]==null로 제어

public class test1463_2 {
	static Integer[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		arr = new Integer[X+1];
		
		arr[0] = 0;
		arr[1] = 0;
		
		System.out.println(makeOne(X));
	}
	
	public static int makeOne( int X ) {
		if(arr[X]==null) {
			if(X%6==0) {
				arr[X] = Math.min(Math.min(makeOne(X/3), makeOne(X/2)), makeOne(X-1)) + 1;
			}else if(X%3==0) {
				arr[X] = Math.min(makeOne(X/3), makeOne(X-1)) + 1;
			}else if(X%2==0) {
				arr[X] = Math.min(makeOne(X/2), makeOne(X-1)) + 1;
			}else {
				arr[X] = makeOne(X-1) + 1;
			}
		}
		return arr[X];
	}
}
