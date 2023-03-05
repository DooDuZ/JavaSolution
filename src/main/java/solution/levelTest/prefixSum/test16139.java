package solution.levelTest.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class test16139 {
    static Map<Character, Integer[]> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int T = Integer.parseInt(br.readLine());

        int lng = str.length();

        for(char i = 'a' ; i<'a'+26 ; i++){
            Integer[] arr = new Integer[lng];
            Arrays.fill(arr, 0);
            map.put( i, arr);

        }

        map.get(str.charAt(0))[0] = 1;

        for(int i = 1 ; i<lng; i++){
            for( char tmp : map.keySet() ){
                Integer[] arr = map.get(tmp);
                arr[i] = arr[i-1];
                if(str.charAt(i) == tmp ){
                    arr[i] += 1;
                }
            }
        }

        StringTokenizer st;
        for(int i = 0 ;i<T; i++){
            st = new StringTokenizer(br.readLine());

            char character = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(countChar(character, start, end)).append("\n");
        }

        System.out.println(sb);
    }

    public static int countChar(char character, int start, int end){
        Integer[] arr = map.get(character);

        if(start == 0){
            return arr[end];
        }
        return arr[end]-arr[start-1];
    }
}
