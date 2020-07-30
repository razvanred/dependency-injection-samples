package ro.razvan.kotlin.dagger.atm

import java.math.BigDecimal
import javax.inject.Inject

class Database @Inject constructor() {
    private val accounts: MutableMap<String, Account> = HashMap()

    fun getAccount(username: String): Account =
        accounts.computeIfAbsent(username) { Account(it) }

    class Account(val username: String) {
        var balance: BigDecimal = BigDecimal.ZERO
            private set
    }
}