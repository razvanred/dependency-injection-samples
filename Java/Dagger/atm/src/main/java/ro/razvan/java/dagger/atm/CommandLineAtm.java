package ro.razvan.java.dagger.atm;

import java.util.Scanner;

public class CommandLineAtm {

    public static void main(String[] args) {
        try(final var scanner = new Scanner(System.in)) {
            final var commandRouter = CommandRouterFactory.create().router();
            while(scanner.hasNextLine()) {
                commandRouter.route(scanner.nextLine());
            }
        }
    }
}
