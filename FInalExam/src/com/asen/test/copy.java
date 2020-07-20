package com.asen.test;

import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.stream.Stream;

public class copy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        TreeMap<String, Integer> users = new TreeMap<>();
        TreeMap <String,Integer> usersREc =new TreeMap<>();

        while (!command.equals("Statistics")) {
            String[] token = command.split("=");
            String userName;
            switch (token[0]) {
                case "Add":
//                    ={username}={sent}={received}":
                    userName = token[1];
                    int send = Integer.parseInt(token[2]);
                    int received = Integer.parseInt(token[3]);
                    if (!users.containsKey(userName)){
                    users.putIfAbsent(userName, send + received);
                    usersREc.putIfAbsent(userName,received);}
                    else {break;}
                    break;
                case "Message":
                    String sender = token[1];
                    String reciver = token[2];
                    if (users.containsKey(sender) && users.containsKey(reciver)) {
                        users.put(sender, users.get(sender) + 1);
                        users.put(reciver, users.get(reciver) + 1);
                        usersREc.put(reciver,1+usersREc.get(reciver));
                    }
                    for (Map.Entry<String, Integer> user : users.entrySet()) {
                        if (user.getValue() >= n) {
                            System.out.println(String.format("%s reached the capacity!", user.getKey()));}}
//                    users.entrySet().
//                            stream().
//                            sorted((a1, a2) -> a2.getValue().
//                                    compareTo(a1.getValue())).limit(1).
//                            filter(e -> e.getValue() >= n).
//                            forEach(z -> System.out.println(String.format("%s reached the capacity!", z.getKey())));
                    break;
                case "Empty":
                    if (token[1].equals("All")) {
                        users.clear();

                    } else if (users.containsKey(token[1])) {
                        users.put(token[1], 0);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        int count = 0;
        for (Map.Entry<String, Integer> entry : users.entrySet()) {
            if (entry.getValue() >= n) {
                count++;
            }
        }
        System.out.println(String.format("Users count: %s", users.size() - count));
//        usersREc.entrySet().forEach(z-> System.out.println(z));
//
//        System.out.println("<<<<<<<<<<<<<<<<<");
        users.entrySet().stream().
                sorted((a1, a2) -> a2.getValue().
                        compareTo(a1.getValue())).
                filter(z -> z.getValue() < n&&z.getValue()>0).
                forEach(e -> System.out.println(String.format("%s - %s", e.getKey(), e.getValue())));

    }
}


