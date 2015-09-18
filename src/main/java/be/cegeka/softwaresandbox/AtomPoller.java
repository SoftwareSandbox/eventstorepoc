package be.cegeka.softwaresandbox;

import org.apache.abdera.Abdera;
import org.apache.abdera.model.Document;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import org.apache.abdera.model.Link;
import org.apache.abdera.parser.Parser;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

import static java.lang.Thread.sleep;

public class AtomPoller {

    public AtomPoller() throws IOException, InterruptedException {
        Link last = null;

        while (last == null) {
            last = getLastLink("http://127.0.0.1:2113/streams/fiangular");
            if(last == null) {
                sleep(1000);
            }
        }

        while (true) {
            Link current = readPrevious(last);
            if (current.getHref() == last.getHref()) {
                sleep(1000);
            }
            last = current;
        }
    }

    private Link getLastLink(String url) throws IOException {
        Feed feed = getFeed("admin", "changeit", url);
        Link last = feed.getLink("last");
        return last == null ? feed.getLink("self") : last;
    }

    private Feed getFeed(String username, String password, String url) throws IOException {
        URLConnection uc = new URL(url).openConnection();
//        String userpass = username + ":" + password;
//        String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userpass.getBytes()));
//        uc.setRequestProperty("Authorization", basicAuth);
        uc.setRequestProperty("Accept", "application/atom+xml");

        Abdera abdera = new Abdera();
        Parser parser = abdera.getParser();
        Document<Feed> doc = parser.parse(uc.getInputStream(), url.toString());
        return doc.getRoot();
    }


    private Link readPrevious(Link link) throws IOException {
        Feed feed = getFeed("admin", "changeit", link.getHref().toString());
        List<Entry> entries = feed.getEntries();
        Collections.reverse(new ArrayList(entries));
        for (Entry entry : entries) {
            System.out.println(entry.getTitle());
        }
        Link previous = feed.getLink("previous");
        return previous == null ? link : previous;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new AtomPoller();
    }
}
