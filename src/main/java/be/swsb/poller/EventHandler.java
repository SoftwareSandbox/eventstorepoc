package be.swsb.poller;

import org.apache.abdera.model.Content;

interface EventHandler {
    void handle(Content event);
}
