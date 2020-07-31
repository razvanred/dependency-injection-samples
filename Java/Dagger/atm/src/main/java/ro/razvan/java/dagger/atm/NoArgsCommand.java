package ro.razvan.java.dagger.atm;

import java.util.List;

public interface NoArgsCommand extends Command {

    @Override
    default Result handleInput(List<String> input) {
        if (!input.isEmpty()) return Result.invalid();
        return handle();
    }

    Result handle();
}
