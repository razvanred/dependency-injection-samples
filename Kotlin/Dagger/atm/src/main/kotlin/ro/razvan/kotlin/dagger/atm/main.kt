package ro.razvan.kotlin.dagger.atm

import java.util.*

fun main() {
    Scanner(System.`in`).use { scanner ->
        val commandProcessor = CommandProcessor()

        while (scanner.hasNextLine()) {
            commandProcessor.route(scanner.nextLine())
        }
    }
}