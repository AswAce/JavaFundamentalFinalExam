package com.asen.test;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DictionarySixApril {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, ArrayList<String>> wodsMeanings = new TreeMap<>();
        Pattern pattern = Pattern.compile("(?<word>[a-zA-Z]+):(?<meanings>[ A-Za-z,]+)");
        String[] word = scanner.nextLine().split("\\s+\\|\\s+");
        for (int i = 0; i < word.length; i++) {
            Matcher matcher = pattern.matcher(word[i]);
            while (matcher.find()) {
                String worde = matcher.group("word");
                String meaning = matcher.group("meanings");
                ArrayList<String> current = wodsMeanings.get(worde);
                if (current == null) {
                    current = new ArrayList<>();
                }
                current.add(meaning);
                wodsMeanings.put(worde, current);
            }
        }
        String[] names = scanner.nextLine().split("\\s+\\|\\s+");
        for (String name : names
        ) {
            if (wodsMeanings.containsKey(name)) {
                System.out.println(name);
                wodsMeanings.get(name).stream().sorted((a1, a2) -> {
                    int first = a1.length();
                    int second = a2.length();
                    return Integer.compare(second, first);
                }).forEach(e -> System.out.println(String.format(" -%s", e.trim()))
                );
            }
        }
        String command = scanner.nextLine();
        if ("List".equals(command)) {
            wodsMeanings.keySet().stream().sorted((a1, a2) -> a1.compareTo(a2)).forEach(e -> System.out.print(e + " "));
        } else if ("End".equals(command)) {
            return;
        }

    }
}
