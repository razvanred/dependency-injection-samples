package ro.razvan.kotlin.dagger.atm

import ro.razvan.kotlin.dagger.atm.Command.Result
import javax.inject.Inject

const val COMMAND_KEY_LOGOUT = "logout"

class LogoutCommand @Inject constructor(
    private val outputter: Outputter
) : NoArgsCommand {

    override fun handle(): Result {
        outputter("Logging out...")
        return Result.inputCompleted()
    }

    override val key: String
        get() = COMMAND_KEY_LOGOUT

}