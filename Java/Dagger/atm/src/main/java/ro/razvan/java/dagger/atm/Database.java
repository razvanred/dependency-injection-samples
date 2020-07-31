package ro.razvan.java.dagger.atm;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

@Singleton
public final class Database {

    private final Map<String, Account> accounts = new HashMap<>();

    @Inject
    public Database() {
    }

    public Account getAccount(String username) {
        return accounts.computeIfAbsent(username, Account::new);
    }

    static final class Account {
        private final String username;
        private BigDecimal balance = BigDecimal.ZERO;

        public Account(String username) {
            this.username = username;
        }

        public BigDecimal balance() {
            return balance;
        }

        public String username() {
            return username;
        }

        public void deposit(BigDecimal amount) {
            balance = balance.add(requireNonNull(amount));
        }

        public void withdraw(final BigDecimal amount) {
            balance = balance.subtract(requireNonNull(amount));
        }
    }
}
