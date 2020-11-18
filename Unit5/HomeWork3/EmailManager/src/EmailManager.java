import java.util.HashSet;

public class EmailManager {

        public HashSet<String> mainList = new HashSet<>();

        public EmailManager(){
            // mainList.add("Первое дело");
        }

        public void commandList(){
           for (String email:mainList){
               System.out.println(email);
           }

        }
        public void commandAdd(String inCommand){
            String text = (inCommand.replaceAll("ADD\\s?\\d?\\s?", ""));
            String regexEmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            if (text.trim().matches(regexEmail)) {
                mainList.add(text);
            } else {
                System.out.println("Email введен неверно");
            }

        }

}

