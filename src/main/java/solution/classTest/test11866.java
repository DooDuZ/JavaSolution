package solution.classTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class test11866 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String answer = "<";
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 1; i<=N; i++) {
			list.add(i);
		}		
		int count=0;
		while(list.size()!=0) {
			count++;
			if(list.size()==1) {
				answer += list.get(0);
				list.remove(0);
				continue;
			}
			if(count%K==0) {
				answer += list.get(0)+", ";
				list.remove(0);
			}else {
				list.add(list.get(0));
				list.remove(0);
			}
		}		
		answer += ">";
		System.out.println(answer);		
	}
}
