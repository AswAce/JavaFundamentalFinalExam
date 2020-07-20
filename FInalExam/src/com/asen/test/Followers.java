package com.asen.test;

import org.w3c.dom.ls.LSOutput;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Followers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, Integer> likes = new TreeMap<>();
        Map<String, Integer> comments = new TreeMap<>();

        while (!command.equals("Log out")) {
            String[] token = command.split(":\\s+");
            String rule = token[0];
            String userName;
            switch (rule) {
                case "New follower":
                    userName = token[1];
                    likes.putIfAbsent(userName, 0);
                    comments.putIfAbsent(userName, 0);
                    break;
                case "Like":
                    userName = token[1];
                    int likesFromUser = Integer.parseInt(token[2]);
                    likes.putIfAbsent(userName, 0);
                    likes.put(userName, likesFromUser + likes.get(userName));
                    comments.putIfAbsent(userName, 0);
                    break;
                case "Comment":
                    userName = token[1];
                    comments.putIfAbsent(userName, 0);
                    comments.put(userName, 1 + comments.get(userName));
                    likes.putIfAbsent(userName, 0);
                    break;
                case "Blocked":
                    userName = token[1];
                    if (likes.containsKey(userName) && comments.containsKey(userName)) {
                        likes.remove(userName);
                        comments.remove(userName);
                    } else {
                        System.out.println(String.format("%s doesn't exist.", userName));
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(String.format("%s followers", likes.size()));

        likes.entrySet().stream().sorted((a1, a2) ->
                {
                    int a = a2.getValue() - a1.getValue();
                    if (a == 0) {
                        return a1.getKey().compareTo(a2.getKey());
                    } else {
                        return a;
                    }
                }
        ).forEach(e -> System.out.println(String.format("%s: %s", e.getKey(), e.getValue() + comments.get(e.getKey()))));

    }
}
