package ro.razvan.kotlin.dagger.atm

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface DepositCommandModule {

    @Binds
    @IntoMap
    @StringKey(COMMAND_KEY_DEPOSIT)
    fun bindDepositCommand(command: DepositCommand): Command

}