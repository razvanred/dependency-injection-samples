package ro.razvan.java.dagger.atm;

import javax.inject.Inject;
import java.math.BigDecimal;

public final class WithdrawCommand implements BigDecimalCommand {

    public static final String COMMAND_KEY_WITHDRAW = "withdraw";

    private final Outputter outputter;
    private final Database.Account account;
    private final BigDecimal minimumBalance;
    private final WithdrawalLimiter withdrawalLimiter;

    @Inject
    public WithdrawCommand(
            Outputter outputter,
            Database.Account account,
            @MinimumBalance BigDecimal minimumBalance,
            WithdrawalLimiter withdrawalLimiter
    ) {
        this.outputter = outputter;
        this.account = account;
        this.minimumBalance = minimumBalance;
        this.withdrawalLimiter = withdrawalLimiter;
    }

    @Override
    public void handleAmount(BigDecimal amount) {
        if (amount.signum() < 0) {
            outputter.output("Cannot withdraw a negative amount");
            return;
        }

        final var remainingWithdrawalLimit = withdrawalLimiter.remainingWithdrawalLimit();

        if (amount.compareTo(remainingWithdrawalLimit) > 0) {
            outputter.output(String.format(
                    "You may not withdraw %s; you may withdraw %s more in this session",
                    amount,
                    remainingWithdrawalLimit
            ));
            return;
        }

        final var newBalance = account.balance().subtract(amount);

        if (newBalance.compareTo(minimumBalance) < 0) {
            outputter.output("Minimum balance reached");
            return;
        }

        account.withdraw(amount);
        withdrawalLimiter.recordWithdrawal(amount);
        outputter.output("Your new balance is: " + account.balance());
    }

    @Override
    public String key() {
        return COMMAND_KEY_WITHDRAW;
    }
}
