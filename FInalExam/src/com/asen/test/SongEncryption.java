package com.asen.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Pattern pattern = Pattern.compile("^(?<artist>[A-Z][a-z' ]+):(?<song>[A-Z ]+)$");
        while (!"end".equals(command)) {
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int key = matcher.group("artist").length();
                String result = upgradeString(matcher.group(), key);
                System.out.println("Successful encryption: " + result);
            } else {
                System.out.println("Invalid input!"
                );
            }

            command = scanner.nextLine();
        }
    }

    private static String upgradeString(String group, int key) {
        int monkeyA = group.indexOf(":");
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < group.length(); i++) {
            if (group.charAt(i) != ' ' || group.charAt(i) != '\'') {
                int current = group.charAt(i);
                int newCHarNumber = current + key;
                if (current==32||current==39){
                    newCHarNumber=current;
                }

                if (newCHarNumber > 90 && Character.isUpperCase(current)) {
                    newCHarNumber -= 26;
                }
                if (newCHarNumber > 122) {
                    newCHarNumber -= 26;
                }
                char newCHar = (char) newCHarNumber;
                returnString.append(newCHar);
            }
        }

        returnString.setCharAt(monkeyA, '@');
        return returnString.toString();
    }
}
