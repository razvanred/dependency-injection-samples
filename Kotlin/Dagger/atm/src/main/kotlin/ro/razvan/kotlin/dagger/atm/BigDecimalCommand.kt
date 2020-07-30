package ro.razvan.kotlin.dagger.atm

import ro.razvan.kotlin.dagger.atm.Command.Result
import java.math.BigDecimal

interface BigDecimalCommand : SingleArgCommand {

    override fun handleArg(arg: String): Result {
        return arg.toBigDecimalOrNull()?.let(::handleAmount) ?: Result.invalid()
    }

    fun handleAmount(amount: BigDecimal): Result

}