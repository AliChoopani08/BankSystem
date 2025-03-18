package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class BankActions {
    protected List<String> transaction=new ArrayList<>();

    protected abstract void deposit(Customers customer);
    protected abstract void withdraw(Customers customer);
    protected abstract void showStock(Customers customer);
    protected abstract void transfer(Customers customer);
    protected abstract void displayInfo(Customers customer);
    protected abstract void changePassword(Customers customer);
}
