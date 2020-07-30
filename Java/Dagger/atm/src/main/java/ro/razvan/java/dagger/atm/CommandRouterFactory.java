package ro.razvan.java.dagger.atm;

import dagger.Component;

import javax.inject.Singleton;

@Component(modules = {
        LoginCommandModule.class,
        HelloWorldCommandModule.class,
        DepositCommandModule.class,
        SystemOutModule.class
})
@Singleton
public interface CommandRouterFactory {

    CommandRouter router();

    static CommandRouterFactory create() {
        return DaggerCommandRouterFactory.create();
    }
}
