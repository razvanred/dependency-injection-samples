package ro.razvan.kotlin.dagger.atm

import ro.razvan.kotlin.dagger.atm.Command.Result
import javax.inject.Inject

const val COMMAND_KEY_HELLO_WORLD = "hello"

class HelloWorldCommand @Inject constructor(
    private val outputter: Outputter
): NoArgsCommand {

    override val key: String
        get() = COMMAND_KEY_HELLO_WORLD

    override fun handle(): Result {
        outputter("world!")
        return Result.handled()
    }
}