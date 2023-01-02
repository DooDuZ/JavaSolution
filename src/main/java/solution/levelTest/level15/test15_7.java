package solution.levelTest.level15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;


public class test15_7 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int Nfac = 1;
		
		for(int i = 1; i<=N; i++) {
			Nfac *= i;
		}
		
		for(int i = 1; i<=K; i++) {
			Nfac /= i;
		}
		
		for(int i = 1; i<=(N-K);i++ ) {
			Nfac /= i;
		}
		
		System.out.println(Nfac);
		
	}
}
