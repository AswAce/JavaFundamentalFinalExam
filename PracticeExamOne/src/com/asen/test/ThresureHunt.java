package com.asen.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class ThresureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> treasure = addTresure(scanner);
        String asw = scanner.nextLine();

        while (!asw.equals("Yohoho!")) {
            String[] command = asw.split("\\s+");
            switch (command[0]) {

                case "Loot":
                    for (int i = 1; i < command.length; i++) {
                        if (!treasure.contains(command[i])) {
                            treasure.add(0, command[i]);
//                                System.out.println(String.join(" ",treasure));
                        }
                    }
                    break;
                case "Drop":

                    if (Integer.parseInt(command[1]) < treasure.size() && Integer.parseInt(command[1]) >= 0) {
//                        String elementToDrop =  treasure.remove(Integer.parseInt(command[1]));
                        treasure.add( treasure.remove(Integer.parseInt(command[1])));
                    }
//                    System.out.println(treasure);
                    break;

                case "Steal":
                    int stolenItems = Integer.parseInt(command[1]);;
//                    if (treasure.size() - stolenItems <= 0) {
//                      treasure.clear();
//                    }

//                    System.out.println(String.join(" ",treasure));
                    ArrayList<String> stolenItem = new ArrayList<>();
                    while (stolenItems > 0 &&!treasure.isEmpty()) {
                        stolenItem.add(treasure.remove(treasure.size()-1));
//                        treasure.remove(treasure.size()-1);
                        stolenItems--;
                    }
                    Collections.reverse(stolenItem);
                    System.out.println(String.join(", ", stolenItem));

                    break;
            }

            asw = scanner.nextLine();
        }
        printAverageTreasure(treasure);

    }

    public static ArrayList<String> addTresure(Scanner scanner) {
        ArrayList<String> output = new ArrayList<>();
        String[] input = scanner.nextLine().split("\\|");
        for (String e : input
        ) {
            output.add(e);

        }
        return output;

    }

    public static void printAverageTreasure(ArrayList<String> chest) {
        double sum = 0;
        for (String s : chest) {
            int oneItemCoins = s.length();
            sum += oneItemCoins;
        }
        double size = chest.size();
        double finalPrice = sum / size;
        if (chest.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.println(String.format("Average treasure gain: %.2f pirate credits.", finalPrice));
        }
        if (chest.size() > 0) {
            double avgTreasure = chest.stream().mapToInt(String::length).average().getAsDouble();
            System.out.printf("Average treasure gain: %.2f pirate credits.", avgTreasure);
        } else {
            System.out.println("Failed treasure hunt.");
        }

    }
}
