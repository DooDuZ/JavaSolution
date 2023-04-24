package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test11444 {

    // static Integer[] dp = new Integer[1_000_000_008];

    /*
        변수가 너무 커서 단순 배열로는 접근하기 어렵다
        행렬 제곱으로 접근해야한다고 함
        선형대수.. 취업하면 꼭 학점은행제로 공부할게요...
        증명을 봤으나 중간 과정이 이해가 안된다.
        일단 구현 하는 방법은

        F(n+1)  ->  [1,1] ^n * [1,0]
        F(n)        [1,0]

        [[1,1][1,0]]^n * [1,0] 을 하면 Fn+1과 Fn이 1열로 계산된다는 것
        하여 조금 변형하면

		                n
		       | 1   1 |    | F(n+1)  F(n)  |
		 A^n = |       |  = |               |
		       | 1   0 |    |  F(n)  F(n-1) |

		증명에 대한 이해는 중간의 몇 개 단어만 알게되면 할 수 있을듯
        일단은 구현부터 진행하겠다.



     */

    static long[][] df = { {1,1}, {1,0} }; // default

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long answer = pow(N-1)[0][0];

        System.out.println(answer);
    }

    public static long[][] pow(long n){
        if(n==1 || n==0){
            return df;
        }

        long[][] ret = pow(n/2 );

        ret = multiply(ret, ret);

        if(n%2==1){
            ret = multiply(ret, df);
        }

        return ret;
    }

    public static long[][] multiply(long[][] e1, long[][] e2){
        long[][] ret = new long[2][2];

        for(int i = 0 ; i<2; i++){
            for(int j = 0; j<2; j++){
                for(int k = 0 ; k<2; k++){
                    ret[i][j] += e1[i][k] * e2[k][j];
                    ret[i][j] %= 1000000007;
                }
            }
        }
        return ret;
    }
}
