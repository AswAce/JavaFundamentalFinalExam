package com.asen.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BattleManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, Integer> personHealth = new TreeMap<>();
        Map<String, Integer> personEnergy = new TreeMap<>();
        while (!command.equals("Results")) {
            String[] token = command.split(":");
            String text = token[0];
            String heroName;
            switch (text) {
                case "Add":
                    heroName = token[1];
                    int health = Integer.parseInt(token[2]);
                    int energy = Integer.parseInt(token[3]);
                    personHealth.putIfAbsent(heroName, 0);
                    personHealth.put(heroName, health + personHealth.get(heroName));
                    personEnergy.putIfAbsent(heroName, energy);
                    break;
                case "Attack":
                    String attackerName = token[1];
                    String defenderName = token[2];
                    int dmg = Integer.parseInt(token[3]);
                    if (personHealth.containsKey(attackerName) && personHealth.containsKey(defenderName)) {
                        int leftHealth = personHealth.get(defenderName) - dmg;
                        int leftEnergy = personEnergy.get(attackerName) - 1;
                        personHealth.put(defenderName, leftHealth);
                        personEnergy.put(attackerName, leftEnergy);
                        if (leftHealth <= 0) {
                            System.out.println(String.format("%s was disqualified!", defenderName));
                            personEnergy.remove(defenderName);
                            personHealth.remove(defenderName);
                        }
                        if (leftEnergy <= 0) {
                            System.out.println(String.format("%s was disqualified!", attackerName));
                            personEnergy.remove(attackerName);
                            personHealth.remove(attackerName);
                        }

                    }

                    break;
                case "Delete":
                    if (token[1].equals("All")) {
                        personEnergy.clear();
                        personHealth.clear();
                    } else if (personHealth.containsKey(token[1])) {
                        personHealth.remove(token[1]);
                        personEnergy.remove(token[1]);
                    }

                    break;
            }

            command = scanner.nextLine();
        }
        System.out.println(String.format("People count: %s", personHealth.size()));
        personHealth.entrySet().stream().sorted((a1, a2) -> {
            int first = a1.getValue();
            int second = a2.getValue();
            if (first == second) {
                return a1.getKey().compareTo(a2.getKey());
            } else {
                return Integer.compare(second, first);
            }

        }).forEach(e -> System.out.println(String.format("%s - %s - %s", e.getKey(), e.getValue(), personEnergy.get(e.getKey()))));


    }
}
