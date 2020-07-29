package ro.razvan.java.dagger.atm;

import java.util.List;

public interface SingleArgCommand extends Command {

    @Override
    default Status handleInput(List<String> input) {
        if(input.size() != 1) return Status.INVALID;

        return handleArg(input.get(0));
    }

    Status handleArg(String arg);

}
