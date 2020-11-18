import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";

        List<String> colors = Arrays.asList(text.split(",?\\s+"));

        Collections.reverse(colors);

        colors.stream().forEach(f -> System.out.println(f));

        //String[] reverseColors = new String[colors.length];




        float totalTemp = 0;
        int countHealthy = 0;
        double minTemp = 36.2;
        double maxTemp = 36.9;
        int countPacients = 30;

        float[] tempPacients = new float[countPacients];

        DecimalFormat df = new DecimalFormat("###.#");

        for (int t = 0; t < countPacients; t++){
            tempPacients[t] = 32 + (float) (Math.random()*8);
            totalTemp += tempPacients[t];

            if (tempPacients[t] > minTemp && tempPacients[t] < maxTemp){
                countHealthy++;
            }

        }
        float avgTemp = totalTemp / 30;

        for (float tempPacient: tempPacients) {
            System.out.println(df.format(tempPacient));
        }

        System.out.println("Средняя температура = " + df.format(avgTemp));
        System.out.println("Кол-во здоровых пациентов = " + countHealthy);

        // Крестик
        int width  = 15;
        int height = 15;
        int x_x = 0;
        int y_x = width - 1;
        boolean check = true;

        for (int i = 0; i < height; i++){
            String crossesLine = "";

            if (i != 0 && check) {
                x_x++;
                y_x--;
            }
            if (!check) {
                x_x--;
                y_x++;
            }

            for (int j = 0; j < width; j++){
                if (j == x_x || j == y_x){
                    crossesLine += 'x';
                } else {
                    crossesLine += ' ';
                } ;
            }

            if (x_x == y_x){
                check = false;
            }
            System.out.println(crossesLine);
        }
    }
}
