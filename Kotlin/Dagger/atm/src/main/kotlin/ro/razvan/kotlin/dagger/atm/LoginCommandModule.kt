package ro.razvan.kotlin.dagger.atm

import dagger.Binds
import dagger.Module

@Module
interface LoginCommandModule {

    @Binds
    fun bindLoginCommand(command: LoginCommand): Command

}