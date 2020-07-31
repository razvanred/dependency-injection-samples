package ro.razvan.java.dagger.atm;

import java.util.List;
import java.util.Optional;

public interface Command {

    String key();

    Result handleInput(List<String> input);

    enum Status {
        INVALID,
        HANDLED,
        INPUT_COMPLETED
    }

    class Result {

        private final Status status;
        private final CommandRouter nestedCommandRouter;

        private Result(Status status) {
            this(status, null);
        }

        private Result(Status status, CommandRouter nestedCommandRouter) {
            this.status = status;
            this.nestedCommandRouter = nestedCommandRouter;
        }

        // region Static Factories
        public static Result handled() {
            return new Result(Status.HANDLED);
        }

        public static Result invalid() {
            return new Result(Status.INVALID);
        }

        public static Result inputCompleted() {
            return new Result(Status.INPUT_COMPLETED);
        }

        public static Result enterNestedCommandSet(CommandRouter nestedCommandRouter) {
            return new Result(Status.HANDLED, nestedCommandRouter);
        }

        public Status status() {
            return status;
        }

        public Optional<CommandRouter> nestedCommandRouter() {
            return Optional.ofNullable(nestedCommandRouter);
        }

        public boolean isHandled() {
            return Status.HANDLED.equals(status);
        }

        public boolean isInvalid() {
            return Status.INVALID.equals(status);
        }

        public boolean isInputCompleted() {
            return Status.INPUT_COMPLETED.equals(status);
        }
        // endregion
    }
}
