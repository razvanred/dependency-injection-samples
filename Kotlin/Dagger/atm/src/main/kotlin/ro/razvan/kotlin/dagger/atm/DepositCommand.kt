package ro.razvan.kotlin.dagger.atm

import ro.razvan.kotlin.dagger.atm.Command.Status
import javax.inject.Inject

const val COMMAND_KEY_DEPOSIT = "deposit"

class DepositCommand @Inject constructor(
    private val outputter: Outputter,
    private val database: Database
) : Command {

    override fun handleInput(input: List<String>): Status {
        if (input.size != 2) return Status.INVALID

        val account = database.getAccount(username = input[0])
        val amount = input[1].toBigDecimalOrNull() ?: return Status.INVALID

        account.deposit(amount)
        outputter("${account.username} now has: ${account.balance}")

        return Status.HANDLED
    }

    override val key: String
        get() = COMMAND_KEY_DEPOSIT

}