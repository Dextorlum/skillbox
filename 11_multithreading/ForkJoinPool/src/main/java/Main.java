import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) {

//        LinkParser linkParser = new LinkParser("https://skillbox.ru");
//        linkParser.getSubSections().forEach(System.out::println);

        ForkJoinPool pool = new ForkJoinPool();

        CardProccesor skillbox = new CardProccesor("https://lenta.ru/");

        pool.execute(skillbox);
        do
        {
            System.out.printf("******************************************\n");
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
            System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
            System.out.printf("******************************************\n");
            try
            {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        } while (!skillbox.isDone());

        pool.shutdown();

        List <String> results;
        results = skillbox.join();

        for (String result : results) {
            System.out.println(result);
        }
    }
}
