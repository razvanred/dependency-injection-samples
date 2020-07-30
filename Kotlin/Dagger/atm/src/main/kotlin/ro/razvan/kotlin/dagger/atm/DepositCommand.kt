package ro.razvan.kotlin.dagger.atm

import ro.razvan.kotlin.dagger.atm.Command.Result
import java.math.BigDecimal
import javax.inject.Inject

const val COMMAND_KEY_DEPOSIT = "deposit"

class DepositCommand @Inject constructor(
    private val outputter: Outputter,
    private val account: Database.Account
) : BigDecimalCommand {

    override fun handleAmount(amount: BigDecimal): Result {
        account.deposit(amount)
        outputter("${account.username} now has: ${account.balance}")

        return Result.handled()
    }

    override val key: String
        get() = COMMAND_KEY_DEPOSIT

}