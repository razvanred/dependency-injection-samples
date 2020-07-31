package ro.razvan.java.dagger.atm;

import javax.inject.Inject;

public class BalanceCommand implements NoArgsCommand {

    public static final String COMMAND_KEY_BALANCE = "balance";

    private final Outputter outputter;
    private final Database.Account account;

    @Inject
    public BalanceCommand(Outputter outputter, Database.Account account) {
        this.outputter = outputter;
        this.account = account;
    }

    @Override
    public Result handle() {
        outputter.output("Your balance is: " + account.balance());
        return Result.handled();
    }

    @Override
    public String key() {
        return COMMAND_KEY_BALANCE;
    }
}
