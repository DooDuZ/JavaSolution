package solution.classTest.class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test9527 {
    static long[] digitCount = new long[55];
    static long[] prefixSum = new long[55];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        digitCount[0] = 1;
        prefixSum[0] = 1;

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        for(int i = 1 ; i<55; i++){
            digitCount[i] = digitCount[i-1]*2 + pow(2, i-1);
            prefixSum[i] = prefixSum[i-1] + digitCount[i];
        }

        long a = getCount(Long.toBinaryString(A-1));
        long b = getCount(Long.toBinaryString(B));

        if(A==1){
            a = 0;
        }

        System.out.println( b - a );
    }

    public static long getCount(String binary){
        long ret = 0L;

        long oneCount = 1;

        boolean check = false;

        ret += prefixSum[binary.length() -1];

        for(int i = 1; i<binary.length(); i++){
            int digit = binary.length() - i -1;

            if(binary.charAt(i)=='1'){
                if(check){
                    ret += prefixSum[digit];
                    ret += (pow( 2, digit+1 )-1) * oneCount;
                    check=false;
                }
                oneCount++;
            }else{
                if(!check){
                    check = true;
                    ret -= (pow( 2, digit+1 )-1) * oneCount;
                    ret -= prefixSum[digit];
                }
            }
        }

        return ret;
    }

    public static long pow(int a, int b){
        if(b==0){
            return 1L;
        }

        long ret = 1L;

        for(int i = 0 ; i<b; i++){
            ret *= a;
        }

        return ret;
    }
}

/*

    1                                               1
    1 2                                             10 11
    1 2 2 3                                         100 101 110 111
    1 2 2 3 2 3 3 4                                 1000 1001 1010 1011 1100 1101 1110 1111
    1 2 2 3 2 3 3 4 2 3 3 4 3 4 4 5                 10000 10001 10010 10011 10100 10101 10110 10111 11000 11001 11010 11011 11100 11101 11110 11111

    각 자리수 별 합으로 바꾼다면

    1
    3 2+1
    8 3*2+2
    20 8*2+4
    48 20*2+8
    .
    .
    .
    dp[n] = dp[n-1]*2 + 2^(n-1)

    ...
    10^16은 2진수 54자리다.
    Long.toBinaryString(10^16) = 100011100001101111001001101111110000010000000000000000
    Long.toBinaryString(10^16).length = 54

    따라서 0~54 길이의 배열이 있다면 누적합으로 처리 가능

    A까지의 누적합과 B까지의 누적합을 구할 수 있다면
    B-A로 처리 가능

    순서

    1. 10진수 A를 2진수로 변환한다. Long.toBinaryString(A)  ex ) 28 -> 11100
    2. 5자리(11111)까지의 누적합은 48... 0인 부분에 해당하는 누적합을 제거해준다
    3. 80 - (4+4+5) [ 11101, 11110, 11111 ] -> 답은 67
       ㄴ 111 은 앞에 있고 뒤의 00 두자리만 바뀌므로 각 자릿수 digit[0] = 1, digit[1-1] = 1, digit[1-2] = 2 에 각 3씩더해서 4,4,5를 빼게 된다. 적고보니 말이 이상하네 ㅋㅋ
       ㄴ 즉 바꿔보면 48-3-(3*3) 그러나 해당 자릿수를 어떻게 계산하느냐?
       ㄴ 2^2 아래의 자연수 1,2,3


    ex2 ) 26 -> 11010

    48 - 3자리 + 2자리 - 1자리?

    80 - ( 14(8 이하의 자연수 7개 * 2) + 12  ) + ( 2*3 + 4 ) - ( 1 + 3(1의자리 앞에서의 1의 개수는 3개다) )
    80 - 26 + 10 - 4
    answer = 60

    반대로 해보자. 4자리 수까지인 20에서 더하기
    10000 10001 10010 10011 10100 10101 10110 10111 11000 11001 11010
    16    17    18    19    20    21    22    23    24    25    26
    1     2     2     3     2     3     3     4     2     3     3

    28

    32 + 28...? = 60

    결국 방법 자체는 해결... 그러나, 하지만, but, however, nevertheless...
    코드로 바꾸는 건 다른 문제다. 일단은 재귀로 할지, for문을 통한 각 지리수 연산을 할 지는 선택해야한다.

    23950 21158 1219 6372
*/
