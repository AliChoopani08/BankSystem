package org.example;

import java.util.*;
import static java.lang.System.out;
import static org.example.MainClassBank.logger;

public class Customers extends BankActions{
    Customers customer2;

    private String account_owner;
    private int account_password;
    private int account_stock;

    Scanner scanner = new Scanner(System.in);

    public Customers() {
    }
    public Customers(String account_owner, int account_password, int account_stock) {
        this.account_owner = account_owner;
        this.account_password = account_password;
        this.account_stock = account_stock;
    }

    @Override
    public void deposit(Customers customer) {
        out.println("Please enter your amount for deposit:");
        int user_amount = scanner.nextInt();
           customer.setAccount_stock(customer.account_stock + user_amount);
            out.println("Deposited amount: " + user_amount);
            logger.info("Remain stock: " + customer.getAccount_stock());
        customer.transaction.add("Deposited amount: " + user_amount  + " ,, Remain stock: " + customer.getAccount_stock());
        out.println("--------------------------------------");
    }

    @Override
    public void withdraw(Customers customer) {
        out.println("Please enter your amount for withdraw");
        int user_amount = scanner.nextInt();
           customer.setAccount_stock(customer.account_stock - user_amount);
            out.println("Withdrawal amount: " + user_amount);
            logger.info("Remain stock: " + customer.getAccount_stock());
        customer.transaction.add("Withdrawal amount: " + user_amount + " ,, Remain stock: " + customer.getAccount_stock());
        out.println("-----------------------------------------");
    }

    @Override
    public void transfer(Customers customer) {
        out.println("Enter account password for destinations account");
        int password=scanner.nextInt();
        Optional<Customers> optionalCustomer2=BankDateBade.find_account_by_password(password);
        optionalCustomer2.ifPresentOrElse(
                acc2->{
                    logger.info("Move to "+acc2.getAccount_owner());
                    customer2=acc2;
                },
                ()-> logger.severe("Not find account!!")
        );
        //Next Step
        out.println("Please enter your amount fo transfer to  " + customer2.account_owner);
        int user_amount = scanner.nextInt();
        if (user_amount < 3000000) {
           customer.setAccount_stock(customer.account_stock - user_amount);
            customer2.setAccount_stock(customer2.account_stock + user_amount);
            logger.info("Move from " + customer.account_owner + " to " + customer2.account_owner + " amount: " + user_amount);
            out.println("Remain from " + customer.account_owner + ": " + customer.getAccount_stock());
            out.println("Remain from " + customer2.account_owner + ": "  + customer2.getAccount_stock());
           customer.transaction.add("Withdraw to: "+customer2.account_owner + " ,,Withdrawal amount: "+user_amount);
           customer2.transaction.add("Receive from: "+customer.account_owner + " ,,Deposit amount: "+user_amount);
        } else {
            logger.warning("Your stock is invalid!");}
        out.println("------------------------------");
    }

    @Override
    public void showStock(Customers customers) {
                out.println(customers.account_owner +" s stock: "+customers.getAccount_stock());
    }

    @Override
    public void changePassword(Customers customers) {
        out.println("Enter your new password");
       if (scanner.hasNextInt()){
           int newPassword= scanner.nextInt();
               customers.setAccount_password(account_password = newPassword);}
        logger.info(customers.account_owner+" s new password: "+customers.getAccount_password());
       customers.transaction.add("Change password,  new password: "+customers.getAccount_password());
    }

        @Override
    public void displayInfo(Customers customers) {
        out.println(customers.account_owner+" s display: "+customers.transaction);
    }

    public void setAccount_password(int account_password) {
        if (account_password>1 && account_password<10000) {
            this.account_password = account_password;
        }else {
            logger.severe("your password is invalid!!");}
    }
    public Integer getAccount_password() {
        return account_password;
    }
    public int getAccount_stock() {
        return account_stock;
    }
    public void setAccount_stock(int account_stock) {
        if (account_stock > 0) {
            this.account_stock = account_stock;
        } else {
           logger.warning("Invalid stock!!");}
    }
    public String getAccount_owner() {
        return account_owner;
    }
}

