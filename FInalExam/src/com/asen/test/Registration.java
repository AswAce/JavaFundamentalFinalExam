package com.asen.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        final Pattern pattern = Pattern.compile("U\\$(?<user>[A-Z][a-z]{2,})U\\$P@\\$(?<pass>[A-Za-z]{5,}[0-9]+)P@\\$");
        int count = 0;
        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                String user = matcher.group("user");
                String password = matcher.group("pass");
                System.out.println("Registration was successful");
                System.out.println(String.format("Username: %s, Password: %s", user, password));
                count++;
            } else {
                System.out.println("Invalid username or password"
                );
            }
        }
        System.out.println(String.format("Successful registrations: %s", count));
    }
}
