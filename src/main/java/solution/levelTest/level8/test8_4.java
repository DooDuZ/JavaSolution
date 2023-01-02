package solution.levelTest.level8;

/* 
	어짜피 scanner나 bufferReader나 입력받는 값이 2개여서 큰 영향 없을 듯 하지만
	여하튼 시간을 조금이라도 줄여보고자 bufferReader사용...
	계속 시간초과 나오는 걸 보니 for문 반복보단 소수 산출 공식을 만들라는 것 같다
	시간을 들여 풀어야할듯
	
	* 주어진 수를 소수들의 집합으로 나누어야할듯
	* 1 , 2 , 3 , 5 , 7 -> 1을 제외하면 모두 소수이면서
	* 그 이후의 숫자들은 소수나 소수의 제곱수, 소수끼리 곱한 수가 아니라면 2,3,5,7 간의 곱하기로 모두 표현이 가능하다
		ㄴ 직관적으로 생각했을 때... 여서 증명은 없음
		ㄴ 정작 쟤들도 소수임
		ㄴ 증명은 추후 도전  -- > 할 필요가 없네...  애초에 소인수 분해가 소수들로만 떨어짐 
	* 배열을 만든 후 for문 작성 ( i = 2 부터 )
	* 소수임이 판별 될 때 마다 배열에 값을 추가하고 -> 사실 그냥 소수로 이루어진 배열, 2부터 시작해도 됌
	* 다음 수들은 해당 배열의 값들로만 나눠보면
	* 소수인지 아닌지 판별 가능
	* but 배열의 길이를 어떻게 정해야할지가 첫번째 문제이며
	* count or index라는 이름의 변수를 선언해서 array[index] 로 사용할 수는 있겠으나
	* 그 방법이 효율적인지 고민해 봐야한다.
	
	
	// 
	* 혹은 소인수 분해를 활용해서
	* 배열을 만든 후에 해당 배열 값들을 활용
	* 여하간 고민 필요
	
	* 결국 이거보다 경우의 수가 적을 수가 있나... 싶은데
	* 계속 시간 초과란다
	* 고민 더 해보기...! 
	* 
	* math.pow 사용해서 제곱근으로 계속 나누는 건 80퍼센트 대에서 오답으로 처리된다.
	* 숫자가 아주 커지면서 시간초과 되는듯 함
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class test8_4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		boolean[] primeNum = new boolean[b+1];
		
		primeNum[0] = true;
		primeNum[1] = true;
		for(int i = 2 ; i<=Math.pow(b, 0.5) ; i++) {
			if(primeNum[i]) {
				continue;
			}
			for(int j = i*i ; j<b+1 ; j+=i) {
				primeNum[j] = true;
			}						
		}
		for(int i = a ; i<=b ; i++) {
			if(!primeNum[i]) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
	
/*
for(int tmp : primeNumber) {
	if(tmp>=a && tmp<=b) {
		System.out.println(tmp);
	}
}
*/
		
		/*
		for(int i = a ; i<=b ; i++) {
			int count = 0;
			for(int j = 2 ; j<i ; j++) {
				if(i%j==0) {
					count++;
					break;
				}
			}
			if(count==1 || i==1) {
				continue;
			}
			System.out.println(i);
		}
		*/



