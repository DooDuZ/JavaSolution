package solution.levelTest.level11;

import java.util.Scanner;

public class test11_5_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int k = scan.nextInt();
		
		int side = (int)Math.pow(3, k);
		
		char[][] arr = new char[side][side];
		for(int i = 0; i<side;i++) {
			for(int j = 0 ; j<side; j++) {
				arr[i][j] = '*';
			}
		}
		
		test11_5_2 test = new test11_5_2();
		
		test.makeBlank(arr, side, side/3, 2*side/3, side/3, 2*side/3);
		
		for(int i = 0 ; i<side; i++) {
			for(int j = 0 ; j<side; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	void makeBlank(char[][] arr, int side, int iblank, int ieblank, int jblank, int jeblank){
		if(side==1) {
			return;
		}
		for(int i = iblank ; i<ieblank ; i++) {
			for(int j = jblank ; j<jeblank ; j++) {
				arr[i][j] = ' ';
			}
		}
		side /= 3;
		
		//좌측
		makeBlank(arr, side, iblank/3, ieblank/3, jblank/3, jeblank/3);
		// makeBlank(arr, side, iblank/3+side, ieblank/3+side, jblank/3, jeblank/3);
		// makeBlank(arr, side, iblank/3+2*side, ieblank/3+2*side, jblank/3, jeblank/3);
		
		//중앙
		makeBlank(arr, side, iblank/3, ieblank/3, jblank/3+side, jeblank/3+side);
		// makeBlank(arr, side, iblank/3+2*side, ieblank/3+2*side, jblank/3+side, jeblank/3+side);
		
		//우측
		// makeBlank(arr, side, iblank/3, ieblank/3, jblank/3+2*side, jeblank/3+2*side);
		// makeBlank(arr, side, iblank/3+side, ieblank/3+side, jblank/3+2*side, jeblank/3+2*side);
		// makeBlank(arr, side, iblank/3+2*side, ieblank/3+2*side, jblank/3+2*side, jeblank/3+2*side);
	}
}
