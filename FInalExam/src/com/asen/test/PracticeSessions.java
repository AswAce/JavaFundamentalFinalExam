package com.asen.test;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PracticeSessions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        Map<String, ArrayList<String>> roads = new TreeMap<>();
        while (!data.equals("END")) {
            String[] token = data.split("->");
            String n = token[0];
            String road;
            String racer;
            String newRoad;
            switch (n) {
                case "Add":
                     road = token[1];
                     racer = token[2];
                    ArrayList<String> currentRoad = roads.get(road);
                    if (currentRoad == null) {
                        currentRoad = new ArrayList<>();
                    }
                        currentRoad.add(racer);
                    roads.put(road, currentRoad);
                    break;
                case "Move":
                    road = token[1];
                    racer = token[2];
                    newRoad = token[3];
                    if (roads.get(road).contains(racer)) {
                        roads.get(road).remove(racer);
                        roads.get(newRoad).add(racer);
                    }
                    break;
                case "Close":
                    road = token[1];
                    roads.remove(road);
                    break;
            }
            data = scanner.nextLine();
        }
        System.out.println("Practice sessions:");
        roads.entrySet().
                stream().
                sorted((a1, a2) -> {
                    int result = a2.getValue().size() - a1.getValue().size();
                    if (result == 0) {
                        return a1.getKey().compareTo(a2.getKey());
                    } else {
                        return result;
                    }
                }).forEach(e -> {
            System.out.println(e.getKey());
            for (String r : e.getValue()
            ) {
                System.out.println("++" + r.trim());
            }
        });

    }
}
