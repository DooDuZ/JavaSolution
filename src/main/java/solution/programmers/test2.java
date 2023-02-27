package solution.programmers;
import java.util.*;
import java.util.stream.Collectors;

public class test2 {

    static LinkedList<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {

        int[] sticker = {123,123};
        Integer[] Sticker = Arrays.stream(sticker).boxed().toArray(Integer[]::new);

        Collections.addAll(queue, Sticker);
/*
        for(int tmp : Sticker) {
            System.out.println(tmp);
        }
*/
        System.out.println(queue.toString());

    }
}
