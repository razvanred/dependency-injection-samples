package ro.razvan.kotlin.dagger.atm

import javax.inject.Inject

const val COMMAND_KEY_BALANCE = "balance"

class BalanceCommand @Inject constructor(
    private val account: Database.Account,
    private val outputter: Outputter
) : NoArgsCommand {

    override fun handle(): Command.Result {
        outputter("Your balance is: ${account.balance}")
        return Command.Result.handled()
    }

    override val key: String
        get() = COMMAND_KEY_BALANCE
}