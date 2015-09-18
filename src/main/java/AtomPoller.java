import org.apache.abdera.Abdera;
import org.apache.abdera.model.Document;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import org.apache.abdera.parser.Parser;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class AtomPoller {

    private Abdera abdera;

    public AtomPoller() {
        abdera = new Abdera();
    }

    public static void main(String[] args){
        AtomPoller atomPoller = new AtomPoller();
        atomPoller.poll();
    }

    private void poll() {
        Parser parser = abdera.getParser();
        URL url = null;
        Document<Feed> doc = null;
        try {
            url = new URL("http://localhost:2113/streams/newstream");
            URLConnection urlConnection = url.openConnection();
            urlConnection.setRequestProperty("Accept", "application/atom+xml");
            doc = parser.parse(urlConnection.getInputStream(),url.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Feed feed = doc.getRoot();
        System.out.println(feed.getTitle());
        for (Entry entry : feed.getEntries()) {
            System.out.println(entry.toString());
        }

    }
}
