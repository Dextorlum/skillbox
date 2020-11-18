import java.util.ArrayList;

public class ListManager {

    public ArrayList<String> mainList = new ArrayList<>();
    public String command;
    public int indexList;
    public String textCommand;

    public ListManager(){
       // mainList.add("Первое дело");
    }

    public void commandList(){
        for (int i = 0; i < mainList.size(); i++){
            System.out.println(i + " - "+mainList.get(i));
        }

    }
    public void commandAdd(String inCommand){
        char charIndex = inCommand.charAt(4);
        String text = inCommand.replaceAll("ADD\\s?\\d?\\s?", "");

        if (Character.isDigit(charIndex)){
            int index = Character.getNumericValue(inCommand.charAt(4));

           if (index > mainList.size() -1){
               mainList.add(text);

           } else {
               mainList.add(index, text);
           }
        } else {
            mainList.add(text);
        }
    }
    public void commandEdit(String inCommand){
        char charIndex = inCommand.charAt(5);
        int index = Character.getNumericValue(inCommand.charAt(5));
        String text = inCommand.replaceAll("EDIT\\s?\\d?\\s?", "");

        if (Character.isDigit(charIndex) && !(index > mainList.size() - 1)){
            mainList.set(index, text);
        }
    }
    public void commandDelete(String inCommand){
        char charIndex = inCommand.charAt(7);
        int index = Character.getNumericValue(inCommand.charAt(7));
        if (Character.isDigit(charIndex) && !(index > mainList.size() - 1)){
            mainList.remove(index);
        }

    }
}
