package ro.razvan.java.dagger.atm;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public interface DepositCommandModule {

    @Binds
    @IntoMap
    @StringKey(DepositCommand.COMMAND_KEY_DEPOSIT)
    Command bindDepositCommand(DepositCommand command);

}
