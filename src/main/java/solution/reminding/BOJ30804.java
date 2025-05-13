// BOJ30804 과일 탕후루 https://www.acmicpc.net/problem/30804

package solution.reminding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ30804 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] food = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            food[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> count = new HashMap<>();

        int max = 0;
        int left = 0;

        for(int i = 0 ; i < N; i++){
            count.put(food[i], count.getOrDefault(food[i], 0) + 1);

            while (count.size() > 2){
                count.put(food[left], count.get(food[left]) - 1);

                if (count.get(food[left]) == 0){
                    count.remove(food[left]);
                }

                left++;
            }

            max = Math.max(max, i - left);
        }

        System.out.println(max + 1);
    }
}
