package ro.razvan.kotlin.dagger.atm

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface HelloWorldCommandModule {

    @Binds
    @IntoMap
    @StringKey(COMMAND_KEY_HELLO_WORLD)
    fun bindHelloWorldCommand(command: HelloWorldCommand): Command
}