package com.asen.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InboxManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, ArrayList<String>> users = new HashMap<>();
        while (!"Statistics".equals(command)) {
            String[] token = command.split("->");
            String text = token[0];
            String username;
            switch (text) {
                case "Add":
                    username = token[1];
                    if (users.containsKey(username)) {
                        System.out.println(String.format("%s is already registered", username));
                    } else {
                        users.put(username, new ArrayList<>());
                    }

                    break;
                case "Send":
                    username = token[1];
                    String email = token[2];
                    if (users.containsKey(username)) {
                        users.get(username).add(email);
                    }

                    break;
                case "Delete":
                    username = token[1];
                    if (!users.containsKey(username)) {
                        System.out.println(String.format("%s not found!", username));
                    } else if (users.containsKey(username)) {
                        users.remove(username);
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.println(String.format("Users count: %s",users.size()));
        users.
                entrySet().
                stream().
                sorted((a1,a2)->{
                    int first=a1.getValue().size();
                    int second=a2.getValue().size();
                    if (first==second){
                    return a1.getKey().compareTo(a2.getKey());}
                    else {return  Integer.compare(second,first);}
                }).forEach(e-> {
                    System.out.println(e.getKey());
                    for (String z: e.getValue()
                         ) {
                        System.out.println((String.format(" - %s",z)));
                    }
                });
    }

}
