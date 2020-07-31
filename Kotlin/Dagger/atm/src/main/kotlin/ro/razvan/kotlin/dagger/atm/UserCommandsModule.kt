package ro.razvan.kotlin.dagger.atm

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface UserCommandsModule {

    @Binds
    @IntoMap
    @StringKey(COMMAND_KEY_DEPOSIT)
    fun bindDepositCommand(command: DepositCommand): Command

    @Binds
    @IntoMap
    @StringKey(COMMAND_KEY_WITHDRAW)
    fun bindWithdrawCommand(command: WithdrawCommand): Command

    @Binds
    @IntoMap
    @StringKey(COMMAND_KEY_LOGOUT)
    fun bindLogoutCommand(command: LogoutCommand): Command

    @Binds
    @IntoMap
    @StringKey(COMMAND_KEY_BALANCE)
    fun bindBalanceCommand(command: BalanceCommand): Command

}