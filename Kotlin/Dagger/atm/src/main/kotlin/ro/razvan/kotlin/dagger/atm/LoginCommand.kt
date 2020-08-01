package ro.razvan.kotlin.dagger.atm

import ro.razvan.kotlin.dagger.atm.Command.Result
import java.util.*
import javax.inject.Inject

const val COMMAND_KEY_LOGIN = "login"

class LoginCommand @Inject constructor(
    private val outputter: Outputter,
    private val database: Database,
    private val userCommandsRouterFactory: UserCommandsRouter.Factory,
    private val account: Optional<Database.Account>
) : SingleArgCommand {

    override val key: String
        get() = COMMAND_KEY_LOGIN

    override fun handleArg(arg: String): Result {
        if (account.isPresent) {
            outputter("${account.get().username} is already logged in!")
            return Result.handled()
        }
        val account = database.getAccount(username = arg)
        outputter("$arg is logged in with balance: ${account.balance}")
        return Result.enterNestedCommandSet(router = userCommandsRouterFactory.create(account).router())
    }
}