package ro.razvan.java.dagger.atm;

import java.util.*;

import ro.razvan.java.dagger.atm.Command.Status;

import javax.inject.Inject;

public final class CommandRouter {

    private final Map<String, Command> commands = new HashMap<>();

    @Inject
    public CommandRouter(HelloWorldCommand helloWorldCommand) {
        commands.put(helloWorldCommand.key(), helloWorldCommand);
    }

    Status route(final String input) {
        final List<String> splitInput = split(input);
        if(splitInput.isEmpty()) {
            return invalidCommand(input);
        }

        final var commandKey = splitInput.get(0);
        final var command = commands.get(commandKey);

        if(command == null) {
            return invalidCommand(input);
        }

        final var status = command.handleInput(splitInput.subList(1, splitInput.size()));
        if(status == Status.INVALID) {
            System.out.println(commandKey + ": invalid arguments");
        }

        return status;
    }

    private Status invalidCommand(final String input) {
        System.out.println(String.format("Could't understand \"%s\". Please try again.", input));
        return Status.INVALID;
    }

    private static List<String> split(final String input) {
        return Arrays.asList(input.split("\\s+"));
    }
}
