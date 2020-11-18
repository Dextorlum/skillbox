public class main {
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i += 2)
//        {
//            System.out.println(i);
//        }

        //----- Цикл FOR
//     for (int age = 15; age < 40; age++){
//
//         System.out.print(age + " лет; вы можете: ");
//
//         if (age >= 16 && age < 18) {
//             System.out.print("иметь ученические права; ");
//         } else if (age >= 18) {
//             System.out.print("иметь обычные права;");
//         } else {
//             System.out.print("вы можете жить обычной жизнью");
//         }
//
//         if (age >= 35) {
//             System.out.print(" вы можете баллотироваться в президенты");
//         }
//
//         System.out.println();
//     }

        //----- Цикл While
        int age = 15;

        while (age < 40)
        {
         System.out.print(age + " лет; вы можете: ");

         if (age >= 16 && age < 18) {
             System.out.print("иметь ученические права; ");
         } else if (age >= 18) {
             System.out.print("иметь обычные права;");
         } else {
             System.out.print("вы можете жить обычной жизнью");
         }

         if (age >= 35) {
             System.out.print(" вы можете баллотироваться в президенты");
         }

         System.out.println();
         age++;
        }
        ;
    }
}
