package com.asen.test;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= Integer.parseInt(scanner.nextLine());
        Pattern pattern=Pattern.compile("!(?<a>[A-Z][a-z]+)!:\\[(?<name>[A-Za-z]{8,})\\]");
        for (int i = 0; i <n ; i++) {
            String text=scanner.nextLine();
            Matcher matcher =pattern.matcher(text);

            if (matcher.find()){
              String endCode=(matcher.group("name"));
                System.out.print(matcher.group("a")+": ");
                for (int j = 0; j <endCode.length()-1 ; j++) {
                    int z=(int)endCode.charAt(j);

                    System.out.print(z+" ");
                }
                System.out.print(0+endCode.charAt(endCode.length()-1));
            }
            else{
                System.out.println();
                System.out.println("The message is invalid");}
        }
    }
}
