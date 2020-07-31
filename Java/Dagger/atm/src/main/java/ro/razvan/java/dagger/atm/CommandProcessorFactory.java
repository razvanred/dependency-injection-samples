package ro.razvan.java.dagger.atm;

import dagger.Component;

import javax.inject.Singleton;

@Component(modules = {
        LoginCommandModule.class,
        HelloWorldCommandModule.class,
        SystemOutModule.class,
        UserCommandsRouter.InstallationModule.class,
        AmountsModule.class
})
@Singleton
public interface CommandProcessorFactory {

    static CommandProcessorFactory create() {
        return DaggerCommandProcessorFactory.create();
    }

    CommandProcessor processor();
}
