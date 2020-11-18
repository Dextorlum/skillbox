import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // Если честно я не сразу понял, что нужно сделать и подсмотрел решение.
        Calendar calendar = Calendar.getInstance();

        calendar.set(1993, Calendar.MARCH, 10);

        Date currentDate = new Date();
        int i = 0;

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy EEEE", new Locale("eng"));

        while (calendar.getTime().compareTo(currentDate) < 0) {

            System.out.println(i + " - " + dateFormat.format(calendar.getTime()));
            calendar.roll(Calendar.YEAR, true);
            i++;

        }

    }
}
