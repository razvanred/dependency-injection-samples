package ro.razvan.kotlin.dagger.atm

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MinimumBalance

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MaximumWithdrawal