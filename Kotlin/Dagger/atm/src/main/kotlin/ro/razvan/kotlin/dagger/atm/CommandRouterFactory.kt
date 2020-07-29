package ro.razvan.kotlin.dagger.atm

import dagger.Component

@Component(modules = [HelloWorldCommandModule::class])
interface CommandRouterFactory {
    fun router(): CommandRouter

    companion object {
        fun create(): CommandRouterFactory =
            DaggerCommandRouterFactory.create()
    }
}