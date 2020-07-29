package ro.razvan.java.dagger.atm;

import javax.inject.Inject;
import java.util.List;

public class HelloWorldCommand implements Command {

    public static final String COMMAND_KEY_HELLO_WORLD = "hello";

    @Inject
    public HelloWorldCommand() {
    }

    @Override
    public String key() {
        return COMMAND_KEY_HELLO_WORLD;
    }

    @Override
    public Status handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return Status.INVALID;
        }

        System.out.println("world!");

        return Status.HANDLED;
    }
}
