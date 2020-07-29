package ro.razvan.kotlin.dagger.atm

import dagger.Module
import dagger.Provides

@Module
object SystemOutModule {

    @Provides
    fun provideSystemOutOutputter(): Outputter =
        object: Outputter {
            override fun invoke(output: String) {
                println(output)
            }
        }
}