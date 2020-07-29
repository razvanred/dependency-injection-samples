package ro.razvan.kotlin.dagger.atm

import ro.razvan.kotlin.dagger.atm.Command.Status

interface NoArgsCommand : Command {

    override fun handleInput(input: List<String>): Status {
        if(input.isNotEmpty()) {
            return Status.INVALID
        }
        return handle()
    }

    fun handle(): Status

}