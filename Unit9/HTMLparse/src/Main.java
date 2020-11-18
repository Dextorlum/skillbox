
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String htmlFile = FileToString("data/data.html");
        //System.out.println(htmlFile);
       Document doc = Jsoup.parse(htmlFile);

       Elements elemenets  = doc.select("img[src$=.jpg]");

       elemenets.forEach(el -> {
           String src = el.attr("src").toString();
           File file = new File(src);
           CopyFile(src, "copyImg/" + file.getName());
           System.out.println("Скачано -" + file.getName());
       });

    }

    public static String FileToString(String path){
      StringBuilder builder = new StringBuilder();

      try {
        List<String> lines = Files.readAllLines(Paths.get(path));
        lines.forEach(line -> {builder.append(line + "\n");});

      } catch (Exception ex) {
          ex.printStackTrace();
      }
      return builder.toString();
    }

    public static void CopyFile(String url, String fileName){

        try {
            BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);

            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
