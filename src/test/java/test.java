import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};

        Integer[] newarr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
    }
}
