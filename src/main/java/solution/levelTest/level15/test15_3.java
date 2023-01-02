package solution.levelTest.level15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class test15_3 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		Map<Integer, Integer> mapA = new HashMap<>();
		Map<Integer, Integer> mapB = new HashMap<>();
		
		int divisor = 2;
		while(true) {
			if(a%divisor==0) {
				a /= divisor;
				if(mapA.containsKey(divisor)) {
					mapA.put(divisor, mapA.get(divisor)+1);
				}else {
					mapA.put(divisor, 1);
				}				
			}else {
				divisor++;
			}
			if(a==1) {
				break;
			}
		}
		divisor = 2;
		while(true) {
			if(b%divisor==0) {
				b /= divisor;
				if(mapB.containsKey(divisor)) {
					mapB.put(divisor, mapB.get(divisor)+1);
				}else {
					mapB.put(divisor, 1);
				}
			}else {
				divisor++;
			}
			if(b==1) {
				break;
			}
		}
		
		int maxDivisor = 1;
		int leastMultiple = 1;
		
		for(int tmp : mapA.keySet()) {
			if(mapB.containsKey(tmp)) {
				int least;
				int maximum;
				if(mapA.get(tmp)>=mapB.get(tmp)) {
					least = mapB.get(tmp);
					maximum = mapA.get(tmp);
				}else {
					least = mapA.get(tmp);
					maximum = mapB.get(tmp);
				}
				for(int i = 0 ; i<least; i++) {
					maxDivisor *= tmp;
				}
				for(int i = 0 ; i<maximum; i++) {
					leastMultiple *= tmp;
				}
			}else {
				for(int i = 0 ; i<mapA.get(tmp); i++) {
					leastMultiple *= tmp;
				}				
			}
		}
		
		for(int tmp : mapB.keySet()) {
			if(!mapA.containsKey(tmp)) {
				for(int i=0; i<mapB.get(tmp); i++) {
					leastMultiple *= tmp;
				}				
			}
		}		
		System.out.println(maxDivisor);
		System.out.println(leastMultiple);						
	}
}
