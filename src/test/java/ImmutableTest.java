public class ImmutableTest {
    public static void main(String[] args) {
        String str = "init";

        changeString(str);

        System.out.println(str);

        Integer number = 25;

        changeInteger(25);

        System.out.println(number);
    }

    private static void changeInteger(Integer param){
        param += 10;
    }


    private static void changeString(String param){
        param += " test";
    }
}
