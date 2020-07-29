package ro.razvan.kotlin.dagger.atm

import ro.razvan.kotlin.dagger.atm.Command.Status

interface SingleArgCommand : Command {

    override fun handleInput(input: List<String>): Status {
        if (input.size != 1) return Status.INVALID

        return handleArg(input[0])
    }

    fun handleArg(arg: String): Status

}