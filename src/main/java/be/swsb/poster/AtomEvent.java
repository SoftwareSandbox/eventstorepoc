package be.swsb.poster;

import java.util.UUID;

/**
 * Created by sch3lp on 21/09/15.
 */
public class AtomEvent {

    private String stream;
    private Payload payload;
    private UUID uuid;

    public AtomEvent(String stream, Payload payload) {
        this.uuid = UUID.randomUUID();
        this.stream = stream;
        this.payload = payload;
    }

    public String getEventType() {
        return stream;
    }

    public Payload getPayload() {
        return payload;
    }

    public UUID getUUID() {
        return uuid;
    }

}
