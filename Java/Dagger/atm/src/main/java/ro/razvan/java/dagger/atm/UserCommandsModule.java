package ro.razvan.java.dagger.atm;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public interface UserCommandsModule {

    @Binds
    @IntoMap
    @StringKey(DepositCommand.COMMAND_KEY_DEPOSIT)
    Command bindDepositCommand(DepositCommand command);

    @Binds
    @IntoMap
    @StringKey(WithdrawCommand.COMMAND_KEY_WITHDRAW)
    Command bindWithdrawCommand(WithdrawCommand command);

    @Binds
    @IntoMap
    @StringKey(BalanceCommand.COMMAND_KEY_BALANCE)
    Command bindBalanceCommand(BalanceCommand command);

    @Binds
    @IntoMap
    @StringKey(LogoutCommand.COMMAND_KEY_LOGOUT)
    Command bindLogoutCommand(LogoutCommand command);

}
