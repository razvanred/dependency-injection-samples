package ro.razvan.kotlin.dagger.atm

import dagger.Module
import dagger.Provides
import java.math.BigDecimal

@Module
object AmountsModule {

    @Provides
    @MaximumWithdrawal
    fun provideMaximumWithdrawal(): BigDecimal = BigDecimal(1_000)

    @Provides
    @MinimumBalance
    fun provideMinimumBalance(): BigDecimal = BigDecimal.ZERO

}