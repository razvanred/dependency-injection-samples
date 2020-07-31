package ro.razvan.java.dagger.atm;

import javax.inject.Inject;
import java.math.BigDecimal;

public class DepositCommand implements BigDecimalCommand {

    public static final String COMMAND_KEY_DEPOSIT = "deposit";

    private final Outputter outputter;
    private final Database.Account account;

    @Inject
    public DepositCommand(Outputter outputter, Database.Account account) {
        this.outputter = outputter;
        this.account = account;
    }

    @Override
    public String key() {
        return COMMAND_KEY_DEPOSIT;
    }

    @Override
    public Result handleAmount(BigDecimal amount) {
        account.deposit(amount);
        outputter.output(account.username() + " now has: " + account.balance());
        return Result.handled();
    }
}
