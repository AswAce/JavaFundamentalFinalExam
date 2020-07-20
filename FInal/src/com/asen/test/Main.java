package com.asen.test;

public class Main {

    public static void main(String[] args) {
//	SomeCLass one =new SomeCLass("One");
//	SomeCLass two=new SomeCLass("Two");
//	SomeCLass three =new SomeCLass("Three");
//		System.out.println(one.getInstance());
//		System.out.println (two.getInstance());
//		System.out.println(three.getInstance());
//Password password =new ExtendedPassword(1234567);
//password.storePassword();
//password.passwordCheck(1234);
//        password.passwordCheck(1222234);
//        password.passwordCheck(123334);
//        password.passwordCheck(1445234);
//        password.passwordCheck(1234567);
        System.out.println("Main method");
        SIBTest test =new SIBTest();
test.someVoid();
        System.out.println("Owner is "+SIBTest.owner);
    }
}
