import java.sql.SQLOutput;

public class main {
    public static void main(String[] args) {
        int someNumber = 80;
        int someNumber2 = 80;
        double newNumber = 2.95_266;
        double newNumber2 = 3.95_67_89;
        String someString = "Какой-то текст";

        int someMultiNumber = someNumber * someNumber2;
        double someMultiDouble = newNumber + newNumber2;

        System.out.println(someMultiNumber);
        System.out.println(someMultiDouble);
    }
}
