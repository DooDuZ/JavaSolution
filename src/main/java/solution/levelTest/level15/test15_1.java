package solution.levelTest.level15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class test15_1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a!=0) {
				if(a>b) {
					if(a%b==0) {
						sb.append("multiple").append('\n');
					}else {
						sb.append("neither").append('\n');
					}
				}else if(b>a){
					if(b%a==0) {
						sb.append("factor").append('\n');
					}else {
						sb.append("neither").append('\n');
					}
				}
			}else {
				break;
			}			
		}
		System.out.println(sb);
	}
}
