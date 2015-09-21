package be.swsb.poster;

import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

public class AtomPoster {


    public AtomPoster() {
    }

    public static void main(String[] args){
        AtomPoster atomPoster = new AtomPoster();
        atomPoster.post(new AtomEvent("MyEventType", new Payload("2", "test")));
    }

    private void post(AtomEvent atomEvent) {
        JerseyClient jerseyClient = new JerseyClientBuilder()
                .register(JacksonFeature.class)
                .build();
        Response response = jerseyClient
                .target("http://localhost:2113/streams/"+atomEvent.getEventType())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("ES-EventId", atomEvent.getUUID())
                .header("ES-EventType", atomEvent.getEventType())
                .post(Entity.json(atomEvent.getPayload()));
        System.out.println(response);
    }
}
