package ro.razvan.java.dagger.atm;

import java.util.Scanner;

public class CommandLineAtm {

    public static void main(String[] args) {
        try(final var scanner = new Scanner(System.in)) {
            final var commandProcessor = CommandProcessorFactory.create().processor();
            while(scanner.hasNextLine()) {
                commandProcessor.process(scanner.nextLine());
            }
        }
    }
}
