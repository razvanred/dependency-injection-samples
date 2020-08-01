package ro.razvan.java.dagger.atm;

import javax.inject.Inject;

public final class HelloWorldCommand implements NoArgsCommand {

    public static final String COMMAND_KEY_HELLO_WORLD = "hello";

    private final Outputter outputter;

    @Inject
    public HelloWorldCommand(Outputter outputter) {
        this.outputter = outputter;
    }

    @Override
    public String key() {
        return COMMAND_KEY_HELLO_WORLD;
    }

    @Override
    public Result handle() {
        outputter.output("world!");
        return Result.handled();
    }
}
