package ro.razvan.java.dagger.atm;

import javax.inject.Inject;

public class LoginCommand implements SingleArgCommand {

    public static final String COMMAND_KEY_LOGIN = "login";

    private final Outputter outputter;
    private final Database database;

    @Inject
    public LoginCommand(Outputter outputter, Database database) {
        this.outputter = outputter;
        this.database = database;
    }

    @Override
    public Status handleArg(String username) {
        final var account = database.getAccount(username);
        outputter.output(account.username() + " is logged in with balance: " + account.balance());
        return Status.HANDLED;
    }

    @Override
    public String key() {
        return COMMAND_KEY_LOGIN;
    }
}
