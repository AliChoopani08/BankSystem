package org.example;

import java.util.*;
import java.util.logging.Logger;
import static java.lang.System.out;

public class MainClassBank {
    public static final Logger logger= Logger.getLogger(MainClassBank.class.getName());
    private final Scanner scanner=new Scanner(System.in);
    Map<Integer, Runnable>actions=new HashMap<>();

    private static final String[] services={"1:deposit, ","2:withdraw, ","3:showStock, ","4:transfer, ","5:displayInfo, ","6:changePassword"};
    private boolean haveRequest=true;

    static {
        String bank_name = "Bank Melli";
        String bank_branch = "Tehran";
        System.out.println("This bank is " + bank_name +" branch " + bank_branch);
        System.out.println("---------------------------------");
    }

    public void start(){
        out.println("Enter your password!");
        int password=scanner.nextInt();
        Optional<Customers>customer=BankDateBade.find_account_by_password(password);

        customer.ifPresentOrElse(
                acc ->{
                    out.println("you are "+acc.getAccount_owner());
                    while (haveRequest) {
                        show_plan(acc);
                        continueOrExit();
                    }
                },
                ()-> logger.warning("Account there is no!!")

        );
    }

    private void show_plan(Customers customer1){
        final Customers customer = new Customers();
        out.println("Select your service: "+ Arrays.toString(services));
            actions.put(1, ()->customer.deposit(customer1));
            actions.put(2, ()-> customer.withdraw(customer1));
            actions.put(3, ()-> customer.showStock(customer1));
            actions.put(4, ()-> customer.transfer(customer1));
            actions.put(5, ()-> customer.displayInfo(customer1));
            actions.put(6, ()-> customer.changePassword(customer1));
        int choice=scanner.nextInt();
            actions.getOrDefault(choice, ()-> out.println("Invalid service!!")).run();
        }

        private void continueOrExit() {
            out.println("Do you have another request?  " + " 1:CONTINUE, " + " 2:EXIT");
            int userRequest = scanner.nextInt();
           switch (userRequest){
               case 1:
                   start();
                   break;
               case 2:
                   out.println("Receive your card");
                   haveRequest=false;
                   scanner.close();
                   break;
           }
        }
}



