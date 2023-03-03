package solution.classTest.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 메모리 초과
    // split사용 후 너무 많은 문자열이 생성되는듯...?
public class test9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        //StringBuffer sf; -> StringBuilder의 동기화 버전. 더 느림...

        String str = br.readLine();
        String pattern = br.readLine();

        int length = str.length()+1;

        while(str.length() != length){
            sb = new StringBuilder();
            //sf = new StringBuffer();

            String[] arr = str.split(pattern);
            length = str.length();
            for(int i = 0; i<arr.length; i++){
                sb.append(arr[i]);
            }
            str = sb.toString();
        }

        if(str.length()==0){
            System.out.printf("FRULA");
        }else{
            System.out.printf(str);
        }
    }
}
