package ro.razvan.kotlin.dagger.atm

import dagger.Component

@Component(modules = [LoginCommandModule::class, SystemOutModule::class])
interface CommandRouterFactory {
    fun router(): CommandRouter

    companion object {
        fun create(): CommandRouterFactory =
            DaggerCommandRouterFactory.create()
    }
}