package ro.razvan.kotlin.dagger.atm

import java.math.BigDecimal
import javax.inject.Inject

@PerSession
class WithdrawalLimiter @Inject constructor(
    @MaximumWithdrawal maximumWithdrawal: BigDecimal
) {

    var remainingWithdrawLimit: BigDecimal
        private set

    init {
        remainingWithdrawLimit = maximumWithdrawal
    }

    fun recordDeposit(amount: BigDecimal) {
        remainingWithdrawLimit += amount
    }

    fun recordWithdrawal(amount: BigDecimal) {
        remainingWithdrawLimit -= amount
    }

}