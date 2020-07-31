package ro.razvan.java.dagger.atm;

import dagger.Module;
import dagger.Provides;

import java.math.BigDecimal;

@Module
public interface AmountsModule {

    @Provides
    @MaximumWithdrawal
    static BigDecimal provideMaximumWithdrawal() {
        return new BigDecimal(1_000);
    }

    @Provides
    @MinimumBalance
    static BigDecimal provideMinimumBalance() {
        return BigDecimal.ZERO;
    }
}
