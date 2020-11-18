import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListManager list = new ListManager();

        while (true) {

        Scanner scanner = new Scanner(System.in);
        String inCommand = scanner.nextLine();

            if (inCommand.equals("LIST")) {
                list.commandList();
            } else if (inCommand.contains("ADD")) {
                list.commandAdd(inCommand);
            } else if (inCommand.contains("DELETE")) {
                list.commandDelete(inCommand);
            } else if (inCommand.contains("EDIT")) {
                list.commandEdit(inCommand);
            } else {break;}
        }

        ArrayList<String> todoList = new ArrayList<>();

        todoList.add("Оло");

        

        todoList.stream().forEach(f -> System.out.println(f));

    }
}
