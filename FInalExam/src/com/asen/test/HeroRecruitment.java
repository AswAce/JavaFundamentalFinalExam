package com.asen.test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class HeroRecruitment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        TreeMap<String, ArrayList<String>> heroes = new TreeMap<>();

        while (!command.equals("End")) {
            String[] token = command.split("\\s+");
            String heroName;
            String spellName;
            switch (token[0]) {
                case "Enroll":
                    heroName = token[1];
                    if (heroes.containsKey(heroName)) {
                        System.out.println(String.format("%s is already enrolled.", heroName));
                    }
                    heroes.putIfAbsent(heroName, new ArrayList<>());
                    break;
                case "Learn":
                    heroName = token[1];
                    spellName = token[2];
                    if (!heroes.containsKey(heroName)) {
                        System.out.println(String.format("%s doesn't exist.", heroName));
                    }
                    if (heroes.containsKey(heroName) && heroes.get(heroName).contains(spellName)) {
                        System.out.println(String.format("%s has already learnt %s.", heroName, spellName));
                    } else if (heroes.containsKey(heroName)) {
                        heroes.get(heroName).add(spellName);
                    }
                    break;
                case "Unlearn":
                    heroName = token[1];
                    spellName = token[2];
                    if (!heroes.containsKey(heroName)) {
                        System.out.println(String.format("%s doesn't exist.", heroName));
                    }
                    if (heroes.containsKey(heroName) && !heroes.get(heroName).contains(spellName)) {
                        System.out.println(String.format("%s doesn't know %s.", heroName, spellName
                        ));
                    }
                    if (heroes.containsKey(heroName) && heroes.get(heroName).contains(spellName)) {
                        heroes.get(heroName).remove(spellName);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Heroes:");
        heroes.entrySet().stream().sorted((a1, a2) -> {
            int first = a1.getValue().size();
            int second = a2.getValue().size();
            if (first==second){ return a1.getKey().compareTo(a2.getKey());}
            else { return Integer.compare(second, first);}
        }).forEach(e -> {

            String a =replace(e.getValue().toString());
            System.out.println(String.format("== %s: %s", e.getKey(), a));


        });
    }

    private static String replace(String value) {
      value= value.replace("[", "");
       value= value.replace("]", "");
        return value;
    }
}
