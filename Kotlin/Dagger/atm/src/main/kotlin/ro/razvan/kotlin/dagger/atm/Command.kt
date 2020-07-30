package ro.razvan.kotlin.dagger.atm

interface Command {

    val key: String

    fun handleInput(input: List<String>): Result

    class Result private constructor(
        val status: Status,
        val nestedCommandRouter: CommandRouter? = null
    ) {
        companion object {
            fun enterNestedCommandSet(router: CommandRouter): Result =
                Result(Status.HANDLED, router)

            fun handled(): Result =
                Result(Status.HANDLED)

            fun inputCompleted(): Result =
                Result(Status.INPUT_COMPLETED)

            fun invalid(): Result =
                Result(Status.INVALID)
        }
    }

    enum class Status {
        INVALID,
        HANDLED,
        INPUT_COMPLETED
    }
}