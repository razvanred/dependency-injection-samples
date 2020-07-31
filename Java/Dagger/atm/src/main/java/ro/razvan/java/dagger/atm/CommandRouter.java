package ro.razvan.java.dagger.atm;

import ro.razvan.java.dagger.atm.Command.Result;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class CommandRouter {

    private final Map<String, Command> commands;
    private final Outputter outputter;

    @Inject
    public CommandRouter(Map<String, Command> commands, Outputter outputter) {
        this.commands = commands;
        this.outputter = outputter;
    }

    Result route(final String input) {
        final List<String> splitInput = split(input);
        if (splitInput.isEmpty()) {
            return invalidCommand(input);
        }

        final var commandKey = splitInput.get(0);
        final var command = commands.get(commandKey);

        if (command == null) {
            return invalidCommand(input);
        }

        final var result = command.handleInput(splitInput.subList(1, splitInput.size()));
        if (result.isInvalid()) {
            outputter.output(commandKey + ": invalid arguments");
        }

        return result;
    }

    private Result invalidCommand(final String input) {
        outputter.output(String.format("Could't understand \"%s\". Please try again.", input));
        return Result.invalid();
    }

    private static List<String> split(final String input) {
        return Arrays.asList(input.split("\\s+"));
    }
}
