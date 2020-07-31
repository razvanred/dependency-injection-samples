package ro.razvan.kotlin.dagger.atm

import java.math.BigDecimal
import javax.inject.Inject

const val COMMAND_KEY_DEPOSIT = "deposit"

class DepositCommand @Inject constructor(
    private val outputter: Outputter,
    private val account: Database.Account
) : BigDecimalCommand {

    override fun handleAmount(amount: BigDecimal) {
        account.deposit(amount)
        outputter("${account.username} now has: ${account.balance}")
    }

    override val key: String
        get() = COMMAND_KEY_DEPOSIT

}