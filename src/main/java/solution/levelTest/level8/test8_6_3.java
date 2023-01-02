package solution.levelTest.level8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test8_6_3{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Scanner input = new Scanner(System.in);
		
		// 1~10000 소수 배열 생성
		boolean[] prime = new boolean[10001];
		int count = 0;
		
		prime[0] = true;
		prime[1] = true;
		
		for( int i = 2 ; i<=10000; i++) {
			if(i==2) {
				prime[i] = false;
			}
			
			if(prime[i]) {
				count++;
				continue;
			}else {
				for(int j = i*i ; j<=10000 ; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0 ; i<T ; i++) {
			int x = Integer.parseInt(br.readLine());
			
			int a = x/2;
			int b = x/2;
			
			while(true) {
				if(!prime[a] && !prime[b] && a+b == x) {
					System.out.println(a+" "+b);
					break;
				}else {
					a--;
					b++;
				}
			}			
		}
	}	
}
