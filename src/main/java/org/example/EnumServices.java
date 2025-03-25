package org.example;

public enum EnumServices {
    DEPOSIT(1),WITHDRAW(2), SHOW_STOCK(3),TRANSFER(4), DISPLAY_INFO(5), CHANGE_PASSWORD(6);

   private final int serviceNumber;
    EnumServices(int SN) {
       serviceNumber =SN;
    }

    private int getServiceNumber(){
        return serviceNumber;
    }
    public static EnumServices findByServiceNumber(int number){
        for (EnumServices service : EnumServices.values()){
            if (service.getServiceNumber()==number){
                return service;
            }
        }
        throw new
                IllegalArgumentException("Invalid number : "+number);
    }
}
