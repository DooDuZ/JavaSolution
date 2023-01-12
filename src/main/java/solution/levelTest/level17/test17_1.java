package solution.levelTest.level17;

import java.util.Scanner;

public class test17_1 {
    static int[] dp = new int[41];
    static int countRe = 0;
    static int countDp = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        dp[1] = 1;
        dp[2] = 1;

        fib(n);
        fibonacci(n);

        System.out.print(countRe + " " + countDp);
    }

    public static int fib(int n) {
        if (n == 1 || n == 2){
            countRe++;
            return 1;
        }else {
            return (fib(n - 1) + fib(n - 2));
        }
    }

    public static int fibonacci( int n) {
        if(dp[n]!=0){
            return dp[n];
        }
        countDp++;
        dp[n] = fibonacci(n-1) + fibonacci(n-2);
        return dp[n];
    }
}
