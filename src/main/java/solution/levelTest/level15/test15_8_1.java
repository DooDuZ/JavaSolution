package solution.levelTest.level15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

// 1000!은 숫자가 너무 크다.
	// N! / K! -> N*(N-1)*... K+1 을 for문으로 계산하면서
	// (N-K)! 에 해당하는 숫자를 하나씩 나눠주면 숫자가 너무 커지는 걸 방지할 수 있지 않을까? 에서 출발함
	// 개같이 오답... 수학에 편법은 없다
	// 공식 정리해서 재도전 예정

public class test15_8_1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int first = 1;
		int count = 1;
		
		int second;
		
		if(K>(N-K)) {
			second = K;
		}else {
			second = N-K;
		}
		
		for(int i = N; i>K; i--) {
			first *= i;
			
			while(count <= second) {
				if(first/count == 0) {
					break;
				}
				if(first%count==0) {
					first /= count;
					count++;
				}else {
					break;
				}
			}
		}		
		System.out.println(first);		
	}
}
