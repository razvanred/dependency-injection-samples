package ro.razvan.java.dagger.atm;

import java.math.BigDecimal;

public interface BigDecimalCommand extends SingleArgCommand {

    @Override
    default Result handleArg(String arg) {
        try {
            return handleAmount(new BigDecimal(arg));
        } catch (NumberFormatException exc) {
            return Result.invalid();
        }
    }

    Result handleAmount(BigDecimal amount);
}
