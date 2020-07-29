package ro.razvan.java.dagger.atm;

import dagger.Binds;
import dagger.Module;

@Module
public interface HelloWorldCommandModule {

    @Binds
    Command bindHelloWorldCommand(HelloWorldCommand command);

}
