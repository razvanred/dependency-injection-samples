package ro.razvan.kotlin.dagger.atm

import ro.razvan.kotlin.dagger.atm.Command.Result

interface NoArgsCommand : Command {

    override fun handleInput(input: List<String>): Result {
        if (input.isNotEmpty()) {
            return Result.invalid()
        }
        return handle()
    }

    fun handle(): Result

}