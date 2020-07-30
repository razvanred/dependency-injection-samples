package ro.razvan.kotlin.dagger.atm

import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        LoginCommandModule::class,
        HelloWorldCommandModule::class,
        SystemOutModule::class,
        DepositCommandModule::class
    ]
)
@Singleton
interface CommandRouterFactory {
    fun router(): CommandRouter

    companion object {
        fun create(): CommandRouterFactory =
            DaggerCommandRouterFactory.create()
    }
}