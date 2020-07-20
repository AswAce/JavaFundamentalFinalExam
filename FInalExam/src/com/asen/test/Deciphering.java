package com.asen.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\G[d-z\\{\\}\\|\\#]+$");
        String[] letters = scanner.nextLine().split(" ");
        Matcher matcher = pattern.matcher(code);
        String result = "";
        if (matcher.find()) {
            String codex = matcher.group();
            for (int i = 0; i < codex.length(); i++) {
                int current = codex
                        .charAt(i);
                int newCHar = current - 3;
                char charToPut = (char) newCHar;
                result += charToPut;
            }

        } else {
            System.out.println("This is not the book you are looking for.");
        }
        result = result.replaceAll(letters[0], letters[1]);
        System.out.println(result);

    }
}

