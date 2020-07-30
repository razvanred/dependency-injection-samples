package ro.razvan.kotlin.dagger.atm

import ro.razvan.kotlin.dagger.atm.Command.Result

interface SingleArgCommand : Command {

    override fun handleInput(input: List<String>): Result {
        if (input.size != 1) return Result.invalid()

        return handleArg(input[0])
    }

    fun handleArg(arg: String): Result

}