package be.cegeka.softwaresandbox;

import org.apache.abdera.model.Content;

interface EventHandler {
    void handle(Content event);
}
