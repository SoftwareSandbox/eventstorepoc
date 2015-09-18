package be.cegeka.softwaresandbox;

public class ConsoleOutputEventHandler implements EventHandler {
    @Override
    public void handle(String event) {
        System.out.println(event);
    }
}
