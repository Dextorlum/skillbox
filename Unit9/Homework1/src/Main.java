import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            for (; ; ) {
                Scanner input = new Scanner(System.in);
                String inputLine = input.nextLine();
                if (inputLine.contains("EXIT")) {
                    break;
                }

                File folder = new File(inputLine);
                int sumFileLength = getSummFileLength(inputLine);
                System.out.println("Байт - " + sumFileLength);
                System.out.println("КБайт - " + sumFileLength/1024);
                System.out.println("МБ - " + sumFileLength/Math.pow(1024, 2));
                System.out.println("ГБ - " + (double) sumFileLength/Math.pow(1024, 3));

                //System.out.println(inputLine);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static int getSummFileLength(String path){
        int length = 0;
        File folder = new File(path);
        File[] files = folder.listFiles();

        for (File file : files){
            if (file.isFile()){
                length += file.length();
            }
            if (file.isDirectory()){
                length += getSummFileLength(file.getAbsolutePath());
            }
        }

        return length;
    }
}
