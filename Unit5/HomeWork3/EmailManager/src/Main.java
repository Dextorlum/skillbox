import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmailManager emailList = new EmailManager();

        while (true){
            Scanner scanner = new Scanner(System.in);
            String inCommand = scanner.nextLine();

            if (inCommand.toUpperCase().equals("LIST")) {
                emailList.commandList();
            } else if (inCommand.toUpperCase().contains("ADD")) {
                emailList.commandAdd(inCommand);
            } else {break;}
        }
    }
}
