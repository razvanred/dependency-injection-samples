package ro.razvan.java.dagger.atm;

import java.util.List;

public interface SingleArgCommand extends Command {

    @Override
    default Result handleInput(List<String> input) {
        if (input.size() != 1) return Result.invalid();

        return handleArg(input.get(0));
    }

    Result handleArg(String arg);

}
