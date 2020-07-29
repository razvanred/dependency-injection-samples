package ro.razvan.kotlin.dagger.atm

import dagger.Component

@Component
interface CommandRouterFactory {
    fun router(): CommandRouter

    companion object {
        fun create(): CommandRouterFactory =
            DaggerCommandRouterFactory.create()
    }
}