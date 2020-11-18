import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] letters = {"С", "М", "Т", "В", "А", "Р", "О", "Н", "Е", "У", "Х", "К"};
        Arrays.sort(letters);
        ArrayList<String> numbers = new ArrayList<>();
        System.out.println("Введите регион");
        Scanner scanner1 = new Scanner(System.in);
        int region = scanner1.nextInt();

            //Одинаковые буквы
            for (int i = 0; i < letters.length; i++) {

                for (int j = 1; j <= 10; j++) {
                    numbers.add(String.format("%s%03d%s%02d", letters[i], j, letters[i]+letters[i], region));
                }
                //буквы и цифры
                for (int j = 111; j <= 999; j+=111){
                    numbers.add(String.format("%s%03d%s%02d", letters[i], j, letters[i]+letters[i], region));
                }
            }

            for (int i = 111; i <= 999; i += 111){
                for (int j = 0; j < letters.length; j++){
                    for (int j2 = 0; j2 < letters.length; j2++){
                        for (int k = 0; k < letters.length; k++){
                            numbers.add(String.format("%s%03d%s%02d", letters[j], j, letters[j2]+letters[k], region));
                        }
                    }
                }
            }



        HashSet<String> hashNumbers = new HashSet<>(numbers);
        //hashNumbers.addAll(numbers);
        TreeSet<String> treeNumbers = new TreeSet<>(numbers);
        //treeNumbers.addAll(numbers);
        for (;;) {
            System.out.println("Введите номер");
            Scanner scanner = new Scanner(System.in);
            String text = scanner.nextLine();

            long start = System.nanoTime();
            boolean check = numbers.contains(text);
            long duration = System.nanoTime() - start;
            System.out.println("Поиск перебором: " + (check ? "Номер найден" : "Номер не найден") + ", поиск занял " + duration + " нс ");

            Collections.sort(numbers);

            start = System.nanoTime();
            int index = Collections.binarySearch(numbers, text);
            duration = System.nanoTime() - start;
            check = false;

            if (index > 0) {
                check = true;
            }
            System.out.println("Бинарным поиском по сортированному ArrayList: " + (check ? "Номер найден" : "Номер не найден") + ", поиск занял " + duration + " нс ");

            start = System.nanoTime();
            check = hashNumbers.contains(text);
            duration = System.nanoTime() - start;
            System.out.println("Поиск в HashSet: " + (check ? "Номер найден" : "Номер не найден") + ", поиск занял " + duration + " нс ");

            start = System.nanoTime();
            check = treeNumbers.contains(text);
            duration = System.nanoTime() - start;
            System.out.println("Поиск в TreeSet: " + (check ? "Номер найден" : "Номер не найден") + ", поиск занял " + duration + " нс ");


            System.out.println(hashNumbers.size());
        }
    }

}
