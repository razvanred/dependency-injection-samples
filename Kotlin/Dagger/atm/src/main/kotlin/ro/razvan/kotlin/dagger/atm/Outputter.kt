package ro.razvan.kotlin.dagger.atm

interface Outputter {
    operator fun invoke(output: String)
}