package ro.razvan.kotlin.dagger.atm

import ro.razvan.kotlin.dagger.atm.Command.Result
import java.math.BigDecimal

interface BigDecimalCommand : SingleArgCommand {

    override fun handleArg(arg: String): Result {
        arg.toBigDecimalOrNull()?.let(::handleAmount)
        return Result.handled()
    }

    fun handleAmount(amount: BigDecimal)

}