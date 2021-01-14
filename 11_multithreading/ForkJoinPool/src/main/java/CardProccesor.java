import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CardProccesor extends RecursiveTask <List<String>> {

    private final String url;

    public CardProccesor(String url) {
        this.url = url;
    }

    @Override
    protected List<String> compute() {

        List<String> resultList = new ArrayList<String>();
        List<CardProccesor> tasks = new ArrayList<CardProccesor>();
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LinkParser linkParser = new LinkParser(url);
        List<String> links = linkParser.getSubSections();

        resultList.add(url);
        resultList.addAll(links);

        for (String link : links) {
                CardProccesor task = new CardProccesor(link);
                task.fork();
                tasks.add(task);
        }
        addResultsFromTasks(resultList, tasks);

        return resultList;
    }
    private void addResultsFromTasks(List<String> list, List<CardProccesor> tasks)
    {
        for (CardProccesor item : tasks)
        {
            list.addAll(item.join());
        }
    }
}
