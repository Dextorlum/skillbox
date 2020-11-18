import java.util.Scanner;

public class Loader
{
    public static void main(String[] args)
    {
        String text = "Маша заработал 600 рублей, Петя - 7563 рубля, а Вася - 300 рублей";
        String[] names = new String[2];
        names[0] = "Вася";
        names[1] = "Маша";

        Integer total = 0;
        for (int i = 0; i <= names.length - 1; i++){
            String substr = text.substring(text.indexOf(names[i]), text.length()-1);
            String summaPerPerson = "";

            for (int j = 0; j <= substr.length() - 1; j++){
                char character = substr.charAt(j);

                if (Character.isDigit(character))
                {  summaPerPerson = summaPerPerson + character;
                }
                if ((Character.isDigit(character)) && (substr.charAt(j+1) == ' ')) {
                 break;
                }
            }
            total = total + Integer.valueOf(summaPerPerson);
        }
        for (;;) {
            System.out.println("Введите ФИО");
            Scanner scanner = new Scanner(System.in);
            String fio = scanner.nextLine();

            String[] words = fio.split(" ");
            boolean check = false;
            String surname = "";
            String name = "";
            String middleName = "";
            for (int w = 0; w <= words.length - 1; w++) {
                if (Character.isUpperCase(words[w].charAt(0))) {
                    if (w == 0) {
                        surname = words[w];
                        check = true;
                    }
                    if (w == 1){
                        name = words[w];
                    }
                    if (w == 2) {
                        middleName = words[w];
                        break;
                    }
                } else {
                    System.out.println("ФИО должно быть такого вида : Фамилия Имя Отчество");
                    check = false;
                    break;
                }
                // System.out.println(words[o]);
            }
            if (!check){
                System.out.println("ФИО введен некорректно");
            } else {
                if (!surname.isEmpty()) {
                    System.out.println("Фамилия : " + surname);
                }
                if (!name.isEmpty()){
                    System.out.println("Имя : " + name);
                }
                if (!middleName.isEmpty()){
                    System.out.println("Отчество : " + middleName);
                }
            }
        }

    }
}
