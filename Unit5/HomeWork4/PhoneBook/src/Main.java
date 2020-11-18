import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<String, String> phoneBook = new TreeMap<>();

        Scanner scanner = new Scanner(System.in);
        String value = "";
        String key = "";

        for(;;)
        {String text = scanner.nextLine();
         if (text.equals("LIST")){
             getMap(phoneBook);
             continue;
          } else {
            if (phoneBook.containsKey(text)){
                System.out.println(text+" - "+phoneBook.get(text));
            } else if (phoneBook.containsValue(text)){
                System.out.println(getKey(phoneBook, text)+" - "+text);
            } else {

                if (text.matches("[^А-Яа-я]+")){
                    if (!text.matches("\\d{11}")) {
                        System.out.println("Номер введен не правильно. Попробуйте еще раз.");
                    }
                    value = text;
                   if (key.isEmpty()) {
                       System.out.println("Введите имя");
                   }
                } else {
                    key = text;
                   if (value.isEmpty()){
                       System.out.println("Введи номер телефона");
                   }
                }
                if (!value.isEmpty() && !key.isEmpty()){
                    phoneBook.put(key, value);
                    key = "";
                    value = "";
                }
            }
         }
        }

    }

    public static void getMap(Map<String, String> map){
        for (String key: map.keySet()){
            System.out.println(key+" - "+map.get(key));
        }
    }
    public static String getKey (Map <String, String> map, String val) {

       for (String key:map.keySet()){
           if (val.equals(map.get(key))){
               return key;
           }
       }
        return null;
    }
}
