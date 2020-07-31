package ro.razvan.kotlin.dagger.atm

import java.math.BigDecimal
import javax.inject.Inject

const val COMMAND_KEY_WITHDRAW = "withdraw"

class WithdrawCommand @Inject constructor(
    private val account: Database.Account,
    private val outputter: Outputter,
    @MinimumBalance private val minimumBalance: BigDecimal,
    @MaximumWithdrawal private val maximumWithdrawal: BigDecimal
) : BigDecimalCommand {

    override fun handleAmount(amount: BigDecimal) {
        if (amount.signum() < 0) {
            outputter("Cannot withdraw a negative amount")
            return
        }

        if (amount > maximumWithdrawal) {
            outputter("Maximum withdrawal reached")
            return
        }

        val newBalance = account.balance - amount

        if (newBalance < minimumBalance) {
            outputter("Minimum balance reached")
            return
        }

        account.withdraw(amount)
        outputter("Your new balance is: ${account.balance}")
    }

    override val key: String
        get() = COMMAND_KEY_WITHDRAW

}