package ro.razvan.java.dagger.atm;

import javax.inject.Inject;
import java.math.BigDecimal;

public final class DepositCommand implements BigDecimalCommand {

    public static final String COMMAND_KEY_DEPOSIT = "deposit";

    private final Outputter outputter;
    private final Database.Account account;
    private final WithdrawalLimiter withdrawalLimiter;

    @Inject
    public DepositCommand(
            Outputter outputter,
            Database.Account account,
            WithdrawalLimiter withdrawalLimiter
    ) {
        this.outputter = outputter;
        this.account = account;
        this.withdrawalLimiter = withdrawalLimiter;
    }

    @Override
    public String key() {
        return COMMAND_KEY_DEPOSIT;
    }

    @Override
    public void handleAmount(BigDecimal amount) {
        account.deposit(amount);
        withdrawalLimiter.recordDeposit(amount);
        outputter.output(account.username() + " now has: " + account.balance());
    }
}
