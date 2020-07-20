package com.asen.test;

import java.util.*;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> judge = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!"no more time".equals(command)) {
            String[] split = command.split(" -> ");

            String name = split[0];
            if (name.contains(" ")){
                break;}
            String course = split[1];
            if (course.contains(" ")){
                break;}
            int points = Integer.parseInt(split[2].trim());
            Map<String, Integer> currentMap = judge.get(course);
            if (currentMap == null) {
                currentMap = new LinkedHashMap<>();
            }
            currentMap.putIfAbsent(name, 0);
            if (points > currentMap.get(name)) {
                currentMap.put(name, points);
            }
            judge.put(course, currentMap);
            command = scanner.nextLine();
        }
        int[] number = {1};
        judge.entrySet().
                stream().
               forEach(e -> {
            System.out.println((e.getKey() + ": " + e.getValue().size() + " participants"));
            e.getValue().entrySet().stream().sorted((s1, s2) -> {
                int compare = s2.getValue() - (s1.getValue());
                if (compare == 0) {
                    return s1.getKey().compareTo(s2.getKey());
                } else {
                    return compare;
                }
            }).forEach(x -> {

                System.out.println(String.format("%s. %s <::> %s", number[0], x.getKey(), x.getValue()));
                number[0]++;
                if (number[0] > e.getValue().size()) {
                    number[0] = 1;
                }
            });
        });
        System.out.println("Individual standings:");
        Map<String, Integer> finalResults = new LinkedHashMap<>();
        for (Map<String, Integer> map : judge.values()) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String name = entry.getKey();
                int points = entry.getValue();
                finalResults.putIfAbsent(name, 0);
                finalResults.put(name, points + finalResults.get(name));
            }
        }
        int[] ranking = {1};
        finalResults.entrySet().stream().sorted((a1, a2) -> {
            int compare = a2.getValue() - a1.getValue();
            if (compare == 0) {
                return a1.getKey().compareTo(a2.getKey());
            } else {
                return compare;
            }
        }).forEach(e -> {
                    System.out.println(String.format("%s. %s -> %s", ranking[0], e.getKey(), e.getValue()));
                    ranking[0]++;
                }
        );


    }
}