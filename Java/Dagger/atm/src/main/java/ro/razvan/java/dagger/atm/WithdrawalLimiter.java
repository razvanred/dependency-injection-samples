package ro.razvan.java.dagger.atm;

import javax.inject.Inject;
import java.math.BigDecimal;

@PerSession
public final class WithdrawalLimiter {

    private BigDecimal remainingWithdrawalLimit;

    @Inject
    public WithdrawalLimiter(@MaximumWithdrawal BigDecimal maximumWithdrawal) {
        remainingWithdrawalLimit = maximumWithdrawal;
    }

    public void recordDeposit(final BigDecimal amount) {
        remainingWithdrawalLimit = remainingWithdrawalLimit.add(amount);
    }

    public void recordWithdrawal(final BigDecimal amount) {
        remainingWithdrawalLimit = remainingWithdrawalLimit.subtract(amount);
    }

    public BigDecimal remainingWithdrawalLimit() {
        return remainingWithdrawalLimit;
    }
}
