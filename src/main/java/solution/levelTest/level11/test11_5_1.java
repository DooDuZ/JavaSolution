package solution.levelTest.level11;

import java.util.Scanner;

public class test11_5_1 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int k = input.nextInt();
		int side = (int) Math.pow(3, k);
		char[][] arr = new char[side][side];
		
		test11_5_1 test = new test11_5_1();
		
		test.setTree(arr, side);
		
		test.makeblank(arr, side);
		
		for(int i = 0; i<side ; i++) {
			for(int j = 0 ; j<side; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		// System.out.println(sb);
	}
	
	void setTree(char[][] arr, int side) {
		for(int i = 0; i<side; i++) {
			for(int j = 0 ; j<side ; j++) {
				arr[i][j] = '*';								
			}
		}
	}
	
	public void makeblank(char[][] arr, int side) {
		
		int sBlank = side/3;
		int eBlank = 2*side/3;
		
		for(int i = sBlank ; i<eBlank ; i++) {
			for(int j = sBlank ; j<eBlank ; j++) {
				arr[i][j] = ' ';
			}
		}
		side /= 3;
		makeblank(arr, side, sBlank/3, eBlank/3, sBlank/3, eBlank/3);
		/*
		makeblank(arr, side, sBlank/3+side, eBlank/3+side, sBlank/3, eBlank/3);
		makeblank(arr, side, sBlank/3+2*side, eBlank/3+2*side, sBlank/3, eBlank/3);
		
		makeblank(arr, side, sBlank/3, eBlank/3, sBlank/3+side, eBlank/3+side);
		makeblank(arr, side, sBlank/3+2*side, eBlank/3+2*side, sBlank/3+side, eBlank/3+side);
		
		makeblank(arr, side, sBlank/3, eBlank/3, sBlank/3+2*side, eBlank/3+2*side);
		makeblank(arr, side, sBlank/3+side, eBlank/3+side, sBlank/3+2*side, eBlank/3+2*side);
		makeblank(arr, side, sBlank/3+2*side, eBlank/3+2*side, sBlank/3+2*side, eBlank/3+2*side);
		*/
	}
	
	public void makeblank(char[][] arr,int side, int isBlank, int ieBlank, int jsBlank, int jeBlank) {
		if(side==1) {
			return;
		}

		System.out.println(side+"길이의 행시작"+isBlank);
		System.out.println(side+"길이의 행끝"+ieBlank);
		System.out.println(side+"길이의 열시작"+jsBlank);
		System.out.println(side+"길이의 열끝"+jeBlank);

		//좌측
		for(int i = isBlank ; i<ieBlank ; i++) {
			for(int j = jsBlank ; j<jeBlank ; j++) {
				arr[i][j] = ' ';
			}
		}
		makeblank(arr, side/3, isBlank/3, ieBlank/3, jsBlank/3, jeBlank/3);
		for(int i = isBlank+side ; i<ieBlank+side ; i++) {
			for(int j = jsBlank ; j<jeBlank ; j++) {
				arr[i][j] = ' ';
			}
		}
		makeblank(arr, side/3, isBlank/3+side, ieBlank/3+side, jsBlank/3, jeBlank/3);
		for(int i = isBlank+2*side ; i<ieBlank+2*side ; i++) {
			for(int j = jsBlank ; j<jeBlank ; j++) {
				arr[i][j] = ' ';
			}
		}
		makeblank(arr, side/3, isBlank/3+2*side, ieBlank/3+2*side, jsBlank/3, jeBlank/3);
		//중앙
		for(int i = isBlank ; i<ieBlank; i++) {
			for(int j = jsBlank+side ; j<jeBlank+side ; j++) {
				arr[i][j] = ' ';
			}
		}
		makeblank(arr, side/3, isBlank/3+2*side, ieBlank/3+2*side, jsBlank/3+side, jeBlank/3+side);
		for(int i = isBlank + 2*side ; i<ieBlank + 2*side; i++) {
			for(int j = jsBlank+side ; j<jeBlank+side ; j++) {
				arr[i][j] = ' ';
			}
		}
		makeblank(arr, side/3, isBlank/3, ieBlank/3, jsBlank/3+side, jeBlank/3+side);
		//우측
		for(int i = isBlank ; i<ieBlank; i++) {
			for(int j = jsBlank+2*side ; j<jeBlank+2*side ; j++) {
				arr[i][j] = ' ';
			}
		}
		makeblank(arr, side/3, isBlank/3, ieBlank/3, jsBlank/3+2*side, jeBlank/3+2*side);
		for(int i = isBlank + side ; i<ieBlank + side; i++) {
			for(int j = jsBlank+2*side ; j<jeBlank+2*side ; j++) {
				arr[i][j] = ' ';
			}
		}
		makeblank(arr, side/3, isBlank/3+side, ieBlank/3+side, jsBlank/3+2*side, jeBlank/3+2*side);
		for(int i = isBlank + 2*side ; i<ieBlank + 2*side; i++) {
			for(int j = jsBlank+2*side ; j<jeBlank+2*side ; j++) {
				arr[i][j] = ' ';
			}
		}
		makeblank(arr, side/3, isBlank/3+2*side, ieBlank/3+2*side, jsBlank/3+2*side, jeBlank/3+2*side);		
		/*
		makeblank(arr, side, isBlank/3, ieBlank/3, jsBlank/3, jeBlank/3);
		makeblank(arr, side, isBlank/3+3*side, ieBlank/3+3*side, jsBlank/3, jeBlank/3);
		makeblank(arr, side, isBlank/3+2*3*side, ieBlank/3+2*3*side, jsBlank/3, jeBlank/3);
		
		makeblank(arr, side, isBlank/3+2*3*side, ieBlank/3+2*3*side, jsBlank/3+3*side, jeBlank/3+3*side);
		makeblank(arr, side, isBlank/3, ieBlank/3, jsBlank/3+3*side, jeBlank/3+3*side);
		
		makeblank(arr, side, isBlank/3, ieBlank/3, jsBlank/3+2*3*side, jeBlank/3+2*3*side);
		makeblank(arr, side, isBlank/3+3*side, ieBlank/3+3*side, jsBlank/3+2*3*side, jeBlank/3+2*3*side);
		makeblank(arr, side, isBlank/3+2*3*side, ieBlank/3+2*3*side, jsBlank/3+2*3*side, jeBlank/3+2*3*side);
		*/	
	}
	
}
/*
	***************************
	* ** ** ** ** ** ** ** ** *
	***************************
	***   ******   ******   ***
	* *   * ** *   * ** *   * *
	***   ******   ******   ***
	***************************
	* ** ** ** ** ** ** ** ** *
	***************************
	*********         *********
	* ** ** *         * ** ** *
	*********         *********
	***   ***         ***   ***
	* *   * *         * *   * *
	***   ***         ***   ***
	*********         *********
	* ** ** *         * ** ** *
	*********         *********
	***************************
	* ** ** ** ** ** ** ** ** *
	***************************
	***   ******   ******   ***
	* *   * ** *   * ** *   * *
	***   ******   ******   ***
	***************************
	* ** ** ** ** ** ** ** ** *
	***************************
*/