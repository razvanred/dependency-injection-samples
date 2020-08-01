package ro.razvan.kotlin.dagger.atm

import java.math.BigDecimal
import javax.inject.Inject

const val COMMAND_KEY_WITHDRAW = "withdraw"

class WithdrawCommand @Inject constructor(
    private val account: Database.Account,
    private val outputter: Outputter,
    @MinimumBalance private val minimumBalance: BigDecimal,
    private val withdrawalLimiter: WithdrawalLimiter
) : BigDecimalCommand {

    override fun handleAmount(amount: BigDecimal) {
        if (amount.signum() < 0) {
            outputter("Cannot withdraw a negative amount")
            return
        }

        val remainingWithdrawalLimit = withdrawalLimiter.remainingWithdrawLimit

        if (amount > remainingWithdrawalLimit) {
            outputter(
                "You may not withdraw $amount; you may withdraw $remainingWithdrawalLimit more in this session"
            )
            return
        }

        val newBalance = account.balance - amount

        if (newBalance < minimumBalance) {
            outputter("Minimum balance reached")
            return
        }

        account.withdraw(amount)
        withdrawalLimiter.recordWithdrawal(amount)
        outputter("Your new balance is: ${account.balance}")
    }

    override val key: String
        get() = COMMAND_KEY_WITHDRAW

}