package ro.razvan.java.dagger.atm;

import dagger.Binds;
import dagger.BindsOptionalOf;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public interface LoginCommandModule {

    @Binds
    @IntoMap
    @StringKey(LoginCommand.COMMAND_KEY_LOGIN)
    Command bindLoginCommand(LoginCommand command);

    @BindsOptionalOf
    Database.Account optionalAccount();

}
