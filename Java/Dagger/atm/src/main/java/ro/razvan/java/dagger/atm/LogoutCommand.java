package ro.razvan.java.dagger.atm;

import javax.inject.Inject;

public class LogoutCommand implements NoArgsCommand {

    public static final String COMMAND_KEY_LOGOUT = "logout";

    private final Outputter outputter;

    @Inject
    public LogoutCommand(Outputter outputter) {
        this.outputter = outputter;
    }

    @Override
    public Result handle() {
        outputter.output("Logging out...");
        return Result.inputCompleted();
    }

    @Override
    public String key() {
        return COMMAND_KEY_LOGOUT;
    }
}
