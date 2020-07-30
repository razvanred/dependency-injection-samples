package ro.razvan.kotlin.dagger.atm

import ro.razvan.kotlin.dagger.atm.Command.Result
import javax.inject.Inject

const val COMMAND_KEY_LOGIN = "login"

class LoginCommand @Inject constructor(
    private val outputter: Outputter,
    private val database: Database,
    private val userCommandsRouterFactory: UserCommandsRouter.Factory
) : SingleArgCommand {

    override val key: String
        get() = COMMAND_KEY_LOGIN

    override fun handleArg(arg: String): Result {
        val account = database.getAccount(username = arg)
        outputter("$arg is logged in with balance: ${account.balance}")
        return Result.enterNestedCommandSet(router = userCommandsRouterFactory.create(account).router())
    }
}