package com.asen.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageEncrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= Integer.parseInt(scanner.nextLine());
        Pattern pattern=Pattern.compile("([@*])(?<tag>[A-Z][a-z]{2,})(\\1): \\[(?<a>[A-Za-z])\\]\\|\\[(?<b>[A-Za-z])\\]\\|\\[(?<c>[A-Za-z])\\]\\|$");

        for (int i = 0; i <n ; i++) {
            String text=scanner.nextLine();
            Matcher matcher=pattern.matcher(text);
            if (matcher.find()){
                String tag=matcher.group("tag");
               String z=(matcher.group("a"));
                String x=(matcher.group("b"));
                String c=(matcher.group("c"));
                int number=z.charAt(0);
                int num =x.charAt(0);
                int numbe=c.charAt(0);
                System.out.println(String.format("%s: %s %s %s",tag,number,num,numbe));
            }
            else if (!matcher.find()) {
            System.out.println("Valid message not found!");}



        }
    }
}
