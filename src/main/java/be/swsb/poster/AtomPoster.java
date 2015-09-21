package be.swsb.poster;

import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.client.JerseyWebTarget;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

public class AtomPoster {


    public AtomPoster() {
    }

    public static void main(String[] args){
        AtomPoster atomPoster = new AtomPoster();
        atomPoster.post(new AtomEvent("newstream", new Payload("1", "test")));
    }

    private void post(AtomEvent atomEvent) {
        JerseyClient jerseyClient = new JerseyClientBuilder().build();
        jerseyClient
                .target("http://localhost:2113/streams/" + atomEvent.getStream())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(atomEvent.getPayload()));
    }
}
