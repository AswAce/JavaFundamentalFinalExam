package com.asen.test;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class OntheWaytoAnnapurna {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, ArrayList<String>> stores = new HashMap<>();
        while (!"END".equals(command)) {
            String[] token = command.split("->|,");
            String msg = token[0];
            String storeName = token[1];
            if (msg.equals("Add")) {
                ArrayList<String> itemsToAdd = stores.get(storeName);
                if (itemsToAdd == null) {
                    itemsToAdd = new ArrayList<>();
                }
                for (int i = 2; i < token.length; i++) {
                    itemsToAdd.add(token[i]);
                }
                stores.put(storeName, itemsToAdd);


            } else if (msg.equals("Remove")) {
                stores.remove(storeName);
            }
            command = scanner.nextLine();
        }
        System.out.println("Stores list:");
        stores.entrySet().stream().sorted((a1, a2) -> {
            int first = a1.getValue().size();
            int sec = a2.getValue().size();
            if (first == sec) {
                return a2.getKey().compareTo(a1.getKey());
            } else {
                return Integer.compare(sec, first);
            }
        }).forEach(e -> {
            System.out.println(e.getKey());
            for (String p : e.getValue()
            ) {
                System.out.println(String.format("<<%s>>", p.trim()));
            }
        });
    }
}
