package ro.razvan.kotlin.dagger.atm

import dagger.Binds
import dagger.Module

@Module
interface HelloWorldCommandModule {

    @Binds
    fun bindHelloWorldCommand(command: HelloWorldCommand): Command
}