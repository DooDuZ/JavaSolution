package solution.levelTest.level9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class test9_7_1 {
	public static void main(String[] args) throws IOException{
		
		// 시간초과 발생
			// x,y를 입력과 동시에 모두 카운팅하고
			// y값 기준 정렬 후
			// x값이 존재한다면 배열 전체 순회[<-여기서 시간 낭비가 심하다... 범위 * x가 존재하는 경우의 수 ]
			// x값들을 순서대로 stringbuilder에 append 한다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		int[] counting = new int[200001];
		int[] countingx = new int[200001];
		
		StringTokenizer st;
		for(int i = 0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			countingx[arr[i][0]+100000]++;
			counting[arr[i][1]+100000]++;
		}
		for(int i = 1 ; i<200001 ; i++) {
			counting[i] += counting[i-1];
		}
		
		int[][] answer = new int[N][2];
		
		for(int i = N-1 ; i>=0 ; i--) {
			answer[counting[arr[i][1]+100000]-1] = arr[i];
			counting[arr[i][1]+100000]--;
		}
		boolean end = true;
		for(int i = 0 ; i<200001; i++) {
			if(!end) {
				break;
			}
			if(countingx[i]!=0) {
				for(int j=0; j<N; j++) {
					if(answer[j][0]==i-100000) {
						sb.append(answer[j][0]+" ").append(answer[j][1]+"\n");
					}
					if(answer[j][0]==N) {
						end=false;
					}
				}				
			}			
		}		
		System.out.println(sb);		
	}
}


/*
for(int i = 0 ; i<N; i++) {
	sb.append(answer[i][0]+" ").append(answer[i][1]+"\n");
}

System.out.println(sb);
*/	