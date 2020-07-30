package ro.razvan.kotlin.dagger.atm

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface LoginCommandModule {

    @Binds
    @IntoMap
    @StringKey(COMMAND_KEY_LOGIN)
    fun bindLoginCommand(command: LoginCommand): Command

}