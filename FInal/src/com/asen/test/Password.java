package com.asen.test;

public class Password {
    public static final int key=4994;
    public final  int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = decryptedPassword(password);
    }
    private int decryptedPassword(int password){
        return password ^key;
    }
    public  void  storePassword(){
        System.out.println("Saving as this "+this.encryptedPassword);
    }
    public void  passwordCheck(int enterPassword){
        if (decryptedPassword(enterPassword)==this.encryptedPassword){
            System.out.println("Welcome back user");
        }
        else {
            System.out.println("Wrong password");
        }
    }
}
