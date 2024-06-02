package solution.levelTest.stringAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1786 {

    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String pattern = br.readLine();

        kmp(str, pattern);

        System.out.println(count);
        System.out.println(sb.toString());
    }

    public static void kmp(String str, String pattern) {
        int[] pi = getPi(pattern);
        int j = 0;

        for (int i = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (str.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    sb.append(i - pattern.length() + 1 + 1).append(" ");
                    // 패턴이 일치한 경우 일치한 인덱스 값에서 패턴의 길이만큼 빼준다
                    // 패턴이 시작되는 위치를 표시하기 위해 인덱스에 +1 한다
                    // 정답은 0-indexed가 아닌 1-indexed를 사용하므로 +1 해준다
                    count++;
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
    }

    public static int[] getPi(String pattern) {
        int[] pi = new int[pattern.length()];

        int j = 0;

        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }

        return pi;
    }
}

/*
 ABBAABABABABAABBFEABAB
 ABABAABB

 i == 0 , j == 0
 ABABAABB
 ABABAABB
 while문 들어가지 않음. j만 ++
 --
 i == 1, j == 1
 ABABAABB
  ABABAABB
 첫번째 while 진입
 B!=A 이므로 j = p[j-1] = 0
 j==0 이므로 while 탈출

 B!=A 이므로 if문 진입X

 --
 i == 2, j == 0
 ABABA ABB
   ABA BAABB

 A==B 이므로 j++ / p[2] == 1
 --
 i == 3, j == 1
 B==A 이므로 j++ / p[3] == 2
 --
 i == 4, j == 2
 A==A 이므로 j++ / p[4] = 3
 --
 i==5, j==3
 A!=B 이므로 / j = p[2] = 1
 --
 i == 6, j == 1
 ABABAABB
      ABABAABB
 B==B 이므로 j++ / p[6] == 2






 */