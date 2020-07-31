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

}
