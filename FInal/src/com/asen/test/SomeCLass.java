package com.asen.test;

public class SomeCLass {
   private  static  int classCounter=0;
    public final int instance;
    private String name;

    public SomeCLass(String name) {
        this.name = name;
classCounter++;
this.instance=classCounter;
        System.out.println("Created instance is "+instance);
    }

    public int getInstance() {
        return instance;
    }
}
