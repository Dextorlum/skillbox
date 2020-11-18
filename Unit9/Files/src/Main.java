import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        try {
            FileInputStream is = new FileInputStream("data/info.txt");
         for (;;) {
             int code = is.read();
             if (code < 0){
                 break;
             }
             char ch = (char) code;
             builder.append(ch);
         }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        //System.out.println(builder.toString());
        builder = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader((new FileReader("data/info.txt")));

            for (;;){
                String line = br.readLine();
                if (line == null){
                    break;
                }
                builder.append(line + "\n");
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println(builder.toString());
    }
}
