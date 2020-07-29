package ro.razvan.java.dagger.atm;

import dagger.Component;

@Component
public interface CommandRouterFactory {

    CommandRouter router();

    static CommandRouterFactory create() {
        return DaggerCommandRouterFactory.create();
    }
}
