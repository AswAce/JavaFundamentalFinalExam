package com.asen.test;

public class SIBTest {
    public static final String owner;
    static {owner="Asen";
        System.out.println("Initialization block is called");}

    public SIBTest() {
        System.out.println("Constructor is called");
    }
    static {
        System.out.println("Second static is called");
    }
    public void someVoid(){
        System.out.println("Some void is called");
    }
    static {
        System.out.println("Third static");
    }
}
