package ro.razvan.java.dagger.atm;

import dagger.Component;

@Component(modules = {LoginCommandModule.class, HelloWorldCommandModule.class, SystemOutModule.class})
public interface CommandRouterFactory {

    CommandRouter router();

    static CommandRouterFactory create() {
        return DaggerCommandRouterFactory.create();
    }
}
