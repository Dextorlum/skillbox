import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int maxConteiners = 3;
        int maxBoxes = 5;
        Scanner scanner = new Scanner(System.in);

       // int trucks = scanner.nextInt();
        int totalBoxes = scanner.nextInt();
        int currTrucks = 1;
        int currConteiners = 1;
//        for (int i = 1; i <= trucks; i++){
//            System.out.println("Грузовик "+i);
//            for (int j = maxConteiners*i -maxConteiners+1 ;j <= maxConteiners*i; j++){
//                System.out.println("  Контейнер "+j);
//
//                for (int k = maxBoxes*j -maxBoxes+1;k <= maxBoxes*j; k++ ){
//                    System.out.println("         Ящик "+k);
//                }
//            }
//        }

        for (int i = 1; i <= totalBoxes; i++){
            if (i % (maxBoxes*maxConteiners) == 1){
                System.out.println("Грузовик "+currTrucks++);
            }
            if (i % maxBoxes == 1) {
                System.out.println("   Контейнер "+currConteiners++);
            }
            System.out.println("          Ящик "+i);
           // System.out.println("  Результат деления "+ i % (maxBoxes*maxConteiners));

        }

    }
}
