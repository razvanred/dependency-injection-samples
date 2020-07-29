package ro.razvan.java.dagger.atm;

import dagger.Binds;
import dagger.Module;

@Module
public interface LoginCommandModule {

    @Binds
    Command bindLoginCommand(LoginCommand command);

}
