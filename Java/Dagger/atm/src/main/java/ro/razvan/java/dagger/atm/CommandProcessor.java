package ro.razvan.java.dagger.atm;

import ro.razvan.java.dagger.atm.Command.Status;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayDeque;
import java.util.Deque;

@Singleton
public final class CommandProcessor {

    private final Deque<CommandRouter> commandRouterStack = new ArrayDeque<>();

    @Inject
    public CommandProcessor(CommandRouter firstCommandRouter) {
        commandRouterStack.push(firstCommandRouter);
    }

    Status process(final String input) {
        final var commandRouter = commandRouterStack.peek();

        if (commandRouter == null) {
            return Status.INVALID;
        }

        final var result = commandRouter.route(input);

        if (result.isInputCompleted()) {
            commandRouterStack.pop();
            return commandRouterStack.isEmpty()
                    ? Status.INPUT_COMPLETED
                    : Status.HANDLED;
        }

        result.nestedCommandRouter().ifPresent(commandRouterStack::push);
        return result.status();
    }
}
