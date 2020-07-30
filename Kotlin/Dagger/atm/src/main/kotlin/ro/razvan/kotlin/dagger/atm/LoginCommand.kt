package ro.razvan.kotlin.dagger.atm

import ro.razvan.kotlin.dagger.atm.Command.Status
import javax.inject.Inject

const val COMMAND_KEY_LOGIN = "login"

class LoginCommand @Inject constructor(
    private val outputter: Outputter,
    private val database: Database
): SingleArgCommand {

    override val key: String
        get() = COMMAND_KEY_LOGIN

    override fun handleArg(arg: String): Status {
        val account = database.getAccount(username = arg)
        outputter("$arg is logged in with balance: ${account.balance}")
        return Status.HANDLED
    }
}