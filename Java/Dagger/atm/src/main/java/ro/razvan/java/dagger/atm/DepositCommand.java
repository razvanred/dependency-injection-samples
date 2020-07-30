package ro.razvan.java.dagger.atm;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

public class DepositCommand implements Command {

    public static final String COMMAND_KEY_DEPOSIT = "deposit";

    private final Outputter outputter;
    private final Database database;

    @Inject
    public DepositCommand(Outputter outputter, Database database) {
        this.outputter = outputter;
        this.database = database;
    }

    @Override
    public String key() {
        return COMMAND_KEY_DEPOSIT;
    }

    @Override
    public Status handleInput(List<String> input) {
        if (input.size() != 2) {
            return Status.INVALID;
        }

        final var account = database.getAccount(input.get(0));
        final BigDecimal amount;

        try {
            amount = new BigDecimal(input.get(1));
        } catch (NumberFormatException exc) {
            return Status.INVALID;
        }

        account.deposit(amount);
        outputter.output(account.username() + " now has: " + account.balance());

        return Status.HANDLED;
    }
}
