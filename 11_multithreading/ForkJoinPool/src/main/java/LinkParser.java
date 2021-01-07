import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class LinkParser {

    private final String url;

    public LinkParser(String url) {
        this.url = url;
    }

    public List<String> getSubSections() {
        Document doc = null;
        List <String> links = new ArrayList<String>();
        try {
            doc = Jsoup.connect(url).maxBodySize(0).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (doc != null) {

            links = doc.getElementsByTag("a").
                    stream().
                    map(e -> e.absUrl("href")).
                    filter(e-> e.startsWith(url) && !e.contains("?") && e.compareTo(url) != 0 &&  !e.contains("#")).
                    distinct().
                    collect(Collectors.toList());
           // links.stream().sorted().forEach(System.out::println);
        }
        return links;
    }

}
