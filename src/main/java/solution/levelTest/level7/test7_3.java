package solution.levelTest.level7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test7_3 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String s = br.readLine();
			int x = Integer.parseInt(s);
			System.out.println(checker(x));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}		
	static String checker(int x) {
		int i = 0;
		int sum = 0;

		int y;
		
		while(true){
			i++;
			sum+=i;
			if(sum>=x){
				y = x-(sum-i)-1;
				break;
			}
		}
		int answer1 = 1+y;
		int answer2 = i-y;
		if(i%2==1){
			return (answer2 + "/" + answer1);
		}else{		
			return (answer1 + "/" + answer2);
		}
	}
}

/*
int x = (int) Math.floor(Math.random()*10000000);
int i = 0;
int sum = 0;

int y;

while(true){
	i++;
	sum+=i;
	if(sum>=x){
		y = x-(sum-i)-1;
		break;
	}
}
int answer1 = 1+y;
int answer2 = i-y;
if(i%2==1){
	System.out.println(answer2 + "/" + answer1);
}else{		
	System.out.println(answer1 + "/" + answer2);
}
*/