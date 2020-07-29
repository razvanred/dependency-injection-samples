package ro.razvan.java.dagger.atm;

import java.util.List;

public interface NoArgsCommand extends Command {

    @Override
    default Status handleInput(List<String> input) {
        if(!input.isEmpty()) return Status.INVALID;
        return handle();
    }

    Status handle();
}
