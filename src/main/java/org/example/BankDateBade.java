package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankDateBade {
    public static final List<Customers>accounts=new ArrayList<>();

    static {
        accounts.add(new Customers("Ali Choopani", 2531, 500000));
        accounts.add(new Customers("Amir Rezaee", 3258, 200000));
        accounts.add(new Customers("Fatemeh Majd", 1387, 1000000));
    }

    public static Optional<Customers> find_account_by_password(int password){
        return accounts.stream()
                .filter(acc -> acc.getAccount_password()==password)
                .findFirst();
    }
}
