public class CallTest {
    public static void main(String[] args) {
        int a = 5;
        int b = 6;

        printSum(a,b);
    }
    // test commit
    static void printSum(int number1, int number2){
        int sum = number1 + number2;
        System.out.println(sum);
    }


    static class Person{
        String name;
        int age;

        Person(){}

        Person(String name, int age){
            this.name = name;
            this.age = age;
        }
    }
}
