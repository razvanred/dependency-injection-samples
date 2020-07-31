package ro.razvan.java.dagger.atm;

import java.math.BigDecimal;

public interface BigDecimalCommand extends SingleArgCommand {

    @Override
    default Result handleArg(String arg) {
        try {
            handleAmount(new BigDecimal(arg));
            return Result.handled();
        } catch (NumberFormatException exc) {
            return Result.invalid();
        }
    }

    void handleAmount(BigDecimal amount);
}
