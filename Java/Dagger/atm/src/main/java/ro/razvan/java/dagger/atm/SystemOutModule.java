package ro.razvan.java.dagger.atm;

import dagger.Module;
import dagger.Provides;

@Module
public interface SystemOutModule {

    @Provides
    static Outputter provideSystemOutOutputter() {
        return System.out::println;
    }
}
