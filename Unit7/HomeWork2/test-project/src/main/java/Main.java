import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        try {
            String data = getDataFromFile("data/test.json");
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(data);
            JSONArray array = new JSONArray();
            array.add(obj);

            for (Object item : array){
                JSONObject jsonObject = (JSONObject) item;
                System.out.println(jsonObject.get("menu"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getDataFromFile(String path)
    {
        StringBuilder builder = new StringBuilder();
        try {
          List<String> lines = Files.readAllLines(Paths.get(path));
          for (String line:lines){
              builder.append(line);
          }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return  builder.toString();

    }
}
