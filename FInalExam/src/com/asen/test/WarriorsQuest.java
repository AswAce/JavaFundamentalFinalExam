package com.asen.test;

import java.util.Scanner;

public class WarriorsQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("For Azeroth")) {
            String[] token = command.split("\\s+");
            switch (token[0]) {
                case "GladiatorStance":
                    text = text.toUpperCase();
                    System.out.println(text);
                    break;
                case "DefensiveStance":
                    text = text.toLowerCase();
                    System.out.println(text);
                    break;
                case "Dispel":
                    int index = Integer.parseInt(token[1]);
                    char letter = token[2].charAt(0);

                    if (index >= 0 && index < text.length()) {
                        StringBuilder st=new StringBuilder(text);
                        for (int i = 0; i <st.length() ; i++) {
                            st.setCharAt(index,letter );
                        }
                        text = st.toString();
                        System.out.println("Success!");
                    } else  {
                        System.out.println("Dispel too weak.");

                    }
                    break;
                case "Target":
                    if (token[1].equals("Change")) {
                        String first = token[2];
                        String second = token[3];
                        text = text.replace(first, second);

                        System.out.println(text);

                    }
                    else if (token[1].equals("Remove")) {

                        String toRemove = token[2];
                        text=text.replace(toRemove,"");
                        System.out.println(text);
                    }else {System.out.println("Command doesn't exist!");}
                    break;
                default:
                    System.out.println("Command doesn't exist!");
                    break;
            }
            command = scanner.nextLine();
        }

    }
}
