package ro.razvan.kotlin.dagger.atm

import ro.razvan.kotlin.dagger.atm.Command.Status
import javax.inject.Inject

class CommandRouter @Inject constructor(
    helloWorldCommand: HelloWorldCommand
) {

    private val commands: MutableMap<String, Command> = HashMap()

    init {
        commands[helloWorldCommand.key] = helloWorldCommand
    }

    fun route(input: String): Status {
        val splitInput = input.split()
        if (splitInput.isEmpty()) {
            return invalidCommand(input)
        }

        val commandKey = splitInput[0]
        val command = commands[commandKey] ?: return invalidCommand(input)

        val status = command.handleInput(splitInput.subList(1, splitInput.size))

        if (status == Status.INVALID) {
            println("$commandKey: invalid arguments")
        }

        return status
    }

    private fun invalidCommand(input: String): Status {
        println("Couldn't understand \"$input\". Please try again.")
        return Status.INVALID
    }
}

private fun String.split() = split(regex = Regex.fromLiteral("\\s+"))