package com.asen.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MessagesManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        TreeMap<String, Integer> users = new TreeMap<>();
        Map<String, Integer> usersRecivingMsg = new HashMap<>();
        while (!command.equals("Statistics")) {
            String[] token = command.split("=");
            String userName;
            switch (token[0]) {
                case "Add":

//                    ={username}={sent}={received}":
                    userName = token[1];
                    int send = Integer.parseInt(token[2]);
                    int received = Integer.parseInt(token[3]);
                    users.putIfAbsent(userName, 0);
                    users.put(userName, send + received);
                    usersRecivingMsg.putIfAbsent(userName, 0);
                    usersRecivingMsg.put(userName, received);
                    break;
                case "Message":
                    String sender = token[1];
                    String reciver = token[2];
                    if (users.containsKey(sender) && users.containsKey(reciver)) {
                        users.put(sender, users.get(sender) + 1);
                        users.put(reciver, users.get(reciver) + 1);
                        usersRecivingMsg.put(reciver, usersRecivingMsg.get(reciver) + 1);
                        if (users.get(sender) >= n) {
                            System.out.println(String.format("%s reached the capacity!", sender));
                            users.remove(sender);
                            usersRecivingMsg.remove(sender);
                        }
                        if (users.get(reciver) >= n){
                            System.out.println(String.format("%s reached the capacity!", reciver));
                        users.remove(reciver);
                        usersRecivingMsg.remove(reciver);}
                    }

                    break;
                case "Empty":
                    if (token[1].equals("All")) {
                        users.clear();
                        usersRecivingMsg.clear();

                    } else if (users.containsKey(token[1])) {
                        users.put(token[1], 0);
                        usersRecivingMsg.put(token[1], n);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        int count = 0;
        for (Map.Entry<String, Integer> entry : usersRecivingMsg.entrySet()) {
            if (entry.getValue() < n) {
                count++;
            }
        }
        System.out.println(String.format("Users count: %s", count));
        usersRecivingMsg.entrySet().stream().sorted((a1, a2) -> {
            if (a1.getValue().equals(a2.getValue())) {
                return a1.getKey().compareTo(a2.getKey());
            } else {
                return a2.getValue().compareTo(a1.getValue());
            }
        }).filter(z -> z.getValue() < n).forEach(e -> {
            System.out.println(finalResult(e.getKey(), users));
        });
    }

    private static String finalResult(String key, Map<String, Integer> user) {
        String result = "";
        if (user.containsKey(key)) {
            result = key + " - " + user.get(key);
        }
        return result;
    }
}