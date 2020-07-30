package ro.razvan.kotlin.dagger.atm

import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        UserCommandsRouter.InstallationModule::class,
        HelloWorldCommandModule::class,
        LoginCommandModule::class,
        SystemOutModule::class
    ]
)
@Singleton
interface CommandProcessorFactory {
    fun processor(): CommandProcessor

    companion object {
        fun create(): CommandProcessorFactory =
            DaggerCommandProcessorFactory.create()
    }
}