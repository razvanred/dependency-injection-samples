package ro.razvan.java.dagger.atm;

import javax.inject.Inject;

public final class LoginCommand implements SingleArgCommand {

    public static final String COMMAND_KEY_LOGIN = "login";

    private final Outputter outputter;
    private final Database database;
    private final UserCommandsRouter.Factory userCommandsRouterFactory;

    @Inject
    public LoginCommand(
            Outputter outputter,
            Database database,
            UserCommandsRouter.Factory userCommandsRouterFactory
    ) {
        this.outputter = outputter;
        this.database = database;
        this.userCommandsRouterFactory = userCommandsRouterFactory;
    }

    @Override
    public Result handleArg(String username) {
        final var account = database.getAccount(username);
        outputter.output(account.username() + " is logged in with balance: " + account.balance());
        return Result.enterNestedCommandSet(userCommandsRouterFactory.create(account).router());
    }

    @Override
    public String key() {
        return COMMAND_KEY_LOGIN;
    }
}
