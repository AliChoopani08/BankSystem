package org.example;

public enum EnumServices {
    DEPOSITE(1),WITHDRAW(2),SHOWSTOCK(3),TRANSFER(4),DISPLAYINFO(5),CHANGEPASSWORD(6);

   private final int serciceNumber;
    EnumServices(int SN) {
       serciceNumber=SN;
    }

    private int getSerciceNumber(){
        return serciceNumber;
    }
    public static EnumServices findByserciveNumber(int number){
        for (EnumServices service : EnumServices.values()){
            if (service.getSerciceNumber()==number){
                return service;
            }
        }
        throw new
                IllegalArgumentException("Invalid number : "+number);
    }
}
