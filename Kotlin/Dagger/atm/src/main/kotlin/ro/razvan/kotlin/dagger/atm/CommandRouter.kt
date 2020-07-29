package ro.razvan.kotlin.dagger.atm

import ro.razvan.kotlin.dagger.atm.Command.Status
import javax.inject.Inject

class CommandRouter @Inject constructor(
    command: Command,
    private val outputter: Outputter
) {

    private val commands: MutableMap<String, Command> = HashMap()

    init {
        commands[command.key] = command
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
            outputter("$commandKey: invalid arguments")
        }

        return status
    }

    private fun invalidCommand(input: String): Status {
        outputter("Couldn't understand \"$input\". Please try again.")
        return Status.INVALID
    }
}

private fun String.split() = split(regex = Regex.fromLiteral("\\s+"))