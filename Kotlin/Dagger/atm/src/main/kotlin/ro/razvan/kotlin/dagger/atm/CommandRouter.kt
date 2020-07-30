@file:Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")

package ro.razvan.kotlin.dagger.atm

import ro.razvan.kotlin.dagger.atm.Command.Result
import ro.razvan.kotlin.dagger.atm.Command.Status
import java.util.Map
import javax.inject.Inject

class CommandRouter @Inject constructor(
    private val commands: Map<String, Command>,
    private val outputter: Outputter
) {

    fun route(input: String): Result {
        val splitInput = input.split()
        if (splitInput.isEmpty()) {
            return invalidCommand(input)
        }

        val commandKey = splitInput[0]
        val command = commands[commandKey] ?: return invalidCommand(input)

        val result = command.handleInput(splitInput.subList(1, splitInput.size))

        if (result.status == Status.INVALID) {
            outputter("$commandKey: invalid arguments")
        }

        return result
    }

    private fun invalidCommand(input: String): Result {
        outputter("Couldn't understand \"$input\". Please try again.")
        return Result.invalid()
    }
}

private fun String.split() = split(regex = Regex.fromLiteral(" "))