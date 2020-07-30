package ro.razvan.java.dagger.atm;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public interface HelloWorldCommandModule {

    @Binds
    @IntoMap
    @StringKey(HelloWorldCommand.COMMAND_KEY_HELLO_WORLD)
    Command bindHelloWorldCommand(HelloWorldCommand command);

}
