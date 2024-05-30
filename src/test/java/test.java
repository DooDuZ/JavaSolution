class test{

    static String[] fibonacci = new String[101];
    static int cnt = 0;
    public static void main(String[] args) {
        fibonacci[0] = "0";
        fibonacci[1] = "1";

        getFibonacci(100);
    }


    private static String getFibonacci(int n){
        cnt++;
        if (fibonacci[n] == null){
            StringBuilder sb = new StringBuilder();
            sb.append(getFibonacci(n-1)).append(getFibonacci(n-2));

            fibonacci[n] = sb.toString();
        }

        return fibonacci[n];
    }

    public static int addBin(int a, int b) {
        if(b == 0) return a;
        //1. 두 비트 XOR 연산 : 두 비트가 다르면 1, 같으면 0
        //즉, 1+0, 0+1은 = 1이고 1+1, 0+0은 0이므로 두 비트의 올림수를 제외하고 덧셈을 할 수 있다.
        int sum = a^b;

        //2. AND 연산 : 두 비트가 모두 1이면 1 (==두 비트가 같을때)
        //1 + 1 의 비트는 올림수가 되므로 왼쪽으로 1 시프트 연산 (<<)
        int carry = (a&b) << 1;

        return addBin(sum, carry);
    }
}