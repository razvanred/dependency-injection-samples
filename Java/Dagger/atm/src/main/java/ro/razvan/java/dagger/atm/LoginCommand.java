package ro.razvan.java.dagger.atm;

import javax.inject.Inject;

public class LoginCommand implements SingleArgCommand {

    public static final String COMMAND_KEY_LOGIN = "login";

    private final Outputter outputter;

    @Inject
    public LoginCommand(Outputter outputter) {
        this.outputter = outputter;
    }

    @Override
    public Status handleArg(String arg) {
        outputter.output(arg + " is logged in.");
        return Status.HANDLED;
    }

    @Override
    public String key() {
        return COMMAND_KEY_LOGIN;
    }
}
