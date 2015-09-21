package be.swsb.poster;

/**
 * Created by sch3lp on 21/09/15.
 */
public class AtomEvent {

    private String stream;
    private Payload payload;

    public AtomEvent(String stream, Payload payload) {
        this.stream = stream;
        this.payload = payload;
    }

    public String getStream() {
        return stream;
    }

    public Payload getPayload() {
        return payload;
    }
}
