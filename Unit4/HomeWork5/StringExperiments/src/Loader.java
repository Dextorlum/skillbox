import java.util.Scanner;

public class Loader
{
    public static void main(String[] args)
    {
        String text = "Маша заработала 600 рублей, Петя - 7563 рубля, а Вася - 300 рублей";
        String[] digits = text.split("[^\\d]+");
        Integer total = 0;

        for (int i = 0; i < digits.length; i++){
            if (!digits[i].isEmpty()) {
                total = total + Integer.valueOf(digits[i]);
            }
           // System.out.println(digits[i]);
        }
        System.out.println(total);
    String engText = "Meet my family. There are five of us – my parents, my elder brother, my baby sister and me. First, meet my mum and dad, Jane and Michael. My mum enjoys reading and my dad enjoys playing chess with my brother Ken. My mum is slim and rather tall. She has long red hair and big brown eyes. She has a very pleasant smile and a soft voice. My mother is very kind and understanding. We are real friends. She is a housewife. As she has three children, she is always busy around the house. She takes care of my baby sister Meg, who is only three months old. My sister is very small and funny. She sleeps, eats and sometimes cries. We all help our mother and let her have a rest in the evening. Then she usually reads a book or just watches TV. My father is a doctor. He is tall and handsome. He has short dark hair and gray eyes. He is a very hardworking man. He is rather strict with us, but always fair. My elder brother Ken is thirteen, and he is very clever. He is good at Maths and always helps me with it, because I can hardly understand all these sums and problems. Ken has red hair and brown eyes. My name is Jessica. I'm eleven. I have long dark hair and brown eyes. I am not as clever as my brother, though I try to do my best at school too. I am fond of dancing. Our dancing studio won The Best Dancing Studio 2015 competition last month. I'm very proud of it. I also like to help my mother with my little sister very much. Our family is very united. We love each other and always try to spend more time together.";

    String[] engWords = engText.split("[^\\'^\\w]+");
    for (int j = 0; j < engWords.length; j++){
          //  System.out.println(engWords[j]);
    }

       // Scanner scanner = new Scanner(System.in);
        String fio = "Дресков, Андрей, Михайлович авыаываыв";

        String[] words = fio.split("[^\\w]");
        int count = 0;
        for (int o = 0; o <= words.length - 1; o++){
            if (!words[o].isEmpty()) {
                if (Character.isUpperCase(words[o].charAt(0))) {
                    if (count == 0) {
                        //System.out.println("Фамилия : " + words[o]);
                    }
                    if (count == 1) {
                        //System.out.println("Имя : " + words[o]);
                    }
                    if (count == 2) {
                        //System.out.println("Отчество : " + words[o]);
                        break;
                    }
                    count++;
                }
            }
        }
        Scanner scanner = new Scanner(System.in);
        String phone = "8 905 1234567";
        String purePhone = phone.replaceAll("[^\\d]", "");

        if (purePhone.length() > 11) {
            purePhone = purePhone.substring(0, 11);
        }
        if (purePhone.charAt(0) == '8'){
            purePhone = purePhone.replaceFirst("8", "7");
        }
        System.out.println(purePhone);


}

}
