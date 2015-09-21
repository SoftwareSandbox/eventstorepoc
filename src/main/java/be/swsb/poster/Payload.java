package be.swsb.poster;

/**
 * Created by sch3lp on 21/09/15.
 */
public class Payload {

    private String id;
    private String message;

    public Payload(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
