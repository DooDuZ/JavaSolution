package solution.classTest.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str,"+-", true);

        boolean sign = true;

        int plus = 0;
        int minus = 0;

        while(st.hasMoreTokens()){

            String numberOrSign = st.nextToken();

            try{
                if(sign){
                    plus += Integer.parseInt(numberOrSign);
                }else{
                    minus -= Integer.parseInt(numberOrSign);
                }
            }catch (NumberFormatException e){
                if(numberOrSign.equals("-")){
                    sign = false;
                }
            }
        }
        System.out.println(plus+minus);
    }
}
