package ro.razvan.kotlin.dagger.atm

import javax.inject.Inject
import ro.razvan.kotlin.dagger.atm.Command.Status

const val COMMAND_KEY_HELLO_WORLD = "hello"

class HelloWorldCommand @Inject constructor(): Command {

    override val key: String
        get() = COMMAND_KEY_HELLO_WORLD

    override fun handleInput(input: List<String>): Status {
        if(input.isNotEmpty()) return Status.INVALID

        println("world!")

        return Status.HANDLED
    }
}