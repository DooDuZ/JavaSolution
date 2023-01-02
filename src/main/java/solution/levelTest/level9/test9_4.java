package solution.levelTest.level9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

public class test9_4 {	
	public static void main(String[] args) throws IOException{
		
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] scores = new int[N];
		
		for(int i = 0 ; i<N ; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		Arrays.sort(scores);
		System.out.println(scores[N-k]);
		*/
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int k = input.nextInt();
		int[] scores = new int[N];
		
		for(int i = 0 ; i<N ; i++) {
			scores[i] = input.nextInt();;
		}
		Arrays.sort(scores);
		System.out.println(scores[N-k]);
	}
}

/*
	5 2
	100 76 85 93 98
*/