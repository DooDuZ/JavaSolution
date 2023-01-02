package solution.classTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test1966 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
				
		for(int i=0 ; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			
			LinkedList<Integer[]> queue = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<size; j++) {
				Integer[] tmp = new Integer[2];
				
				tmp[0] = j;
				tmp[1] = Integer.parseInt(st.nextToken());
				
				queue.add(tmp);
			}

			int count = 0;
			while(true) {				
				boolean check = false;
				
				for(int j = 0 ; j<queue.size(); j++) {
					if(queue.get(0)[1] < queue.get(j)[1]) {
						check = true;
						break;
					}
				}
				Integer[] tmp;
				if(check) {
					tmp = queue.poll();
					queue.add(tmp);
				}else {
					count++;
					tmp = queue.poll();
				}
				
				if(tmp[0] == index || queue.size()==0) {
					if(!check) {
						System.out.println(count);
						break;
					}
				}				
			}
		}
	}
}

/*
 	3
	1 0
	5
	4 2
	1 2 3 4
	6 0
	1 1 9 1 1 1
*/
