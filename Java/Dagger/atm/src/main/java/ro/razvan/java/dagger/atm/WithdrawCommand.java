package ro.razvan.java.dagger.atm;

import javax.inject.Inject;
import java.math.BigDecimal;

public final class WithdrawCommand implements BigDecimalCommand {

    public static final String COMMAND_KEY_WITHDRAW = "withdraw";

    private final Outputter outputter;
    private final Database.Account account;
    private final BigDecimal minimumBalance;
    private final BigDecimal maximumWithdrawal;

    @Inject
    public WithdrawCommand(
            Outputter outputter,
            Database.Account account,
            @MinimumBalance BigDecimal minimumBalance,
            @MaximumWithdrawal BigDecimal maximumWithdrawal
    ) {
        this.outputter = outputter;
        this.account = account;
        this.minimumBalance = minimumBalance;
        this.maximumWithdrawal = maximumWithdrawal;
    }

    @Override
    public void handleAmount(BigDecimal amount) {
        if (amount.signum() < 0) {
            outputter.output("Cannot withdraw a negative amount");
            return;
        }

        if (amount.compareTo(maximumWithdrawal) > 0) {
            outputter.output("Maximum withdrawal reached");
            return;
        }

        final var newBalance = account.balance().subtract(amount);

        if (newBalance.compareTo(minimumBalance) < 0) {
            outputter.output("Minimum balance reached");
            return;
        }

        account.withdraw(amount);
        outputter.output("Your new balance is: " + account.balance());
    }

    @Override
    public String key() {
        return COMMAND_KEY_WITHDRAW;
    }
}
