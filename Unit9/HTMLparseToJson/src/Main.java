import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();

            //System.out.println(doc.toString());

            Elements elements = doc.select("div");
            JSONObject obj = new JSONObject();
            JSONObject lineObj = new JSONObject();
            JSONArray jsonArray = new JSONArray();

            elements.forEach(el -> {
               if (el.attr("class").contains("s-toggle-depend s-depend-control-single  ")){
                   el.children().forEach(element -> {
                       if (element.attr("class").contains("js-metro-line t-metrostation-list-header ")){
                           String dataLine = element.attr("data-line").toString();
                           jsonArray.clear();
                           elements.forEach(element1 -> {
                               if ((element1.attr("class").contains("js-metro-stations t-metrostation-list-table"))
                                   && (element1.attr("data-line") == dataLine)){
                                   element1.children().forEach(element2 -> {
                                       jsonArray.add(element2.text());
                                       //System.out.println(element2.text());
                                   });
                               }

                           });
                           lineObj.put(dataLine, jsonArray);
                       }
                   });
                }
            });
            obj.put("stations", lineObj);

            FileWriter file = new FileWriter("data/stations.json");
            file.write(obj.toJSONString());
            file.flush();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
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
