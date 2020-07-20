package com.asen.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ManOnWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> pirateShip = addShip(scanner);
        ArrayList<String> marines = addShip(scanner);
        int maxHealth = Integer.parseInt(scanner.nextLine());
        boolean flag = true;
        while (flag) {
            String command = scanner.nextLine();
            String[] fight = command.split("\\s+");
            switch (fight[0]) {
                case "Fire":
                    int indexToAttack = Integer.parseInt(fight[1]);
                    int dmg = Integer.parseInt(fight[2]);
                    if (indexToAttack > marines.size()||indexToAttack<0) {
                        break;
                    } else {
                        String indexHealth = marines.get(indexToAttack);
                        int dmgDone = Integer.parseInt(indexHealth) - dmg;
                        if (dmgDone <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            flag = false;
                            break;
                        }
                        marines.set(indexToAttack, String.valueOf(dmgDone));
                    }

                    break;
                case "Defend":
                    int start = Integer.parseInt(fight[1]);
                    int end = Integer.parseInt(fight[2]);
                    int damage = Integer.parseInt(fight[3]);
                    if (start < 0 || end > pirateShip.size()) {
                        break;
                    } else {
                        for (int i = start; i <= end; i++) {
                            int dmgDone = Integer.parseInt(pirateShip.get(i)) - damage;

                            if (dmgDone <= 0) {
                                System.out.println("You lost! The pirate ship has sunken."
                                );
                                flag = false;
                                break;
                            } else {
                                pirateShip.set(i, String.valueOf(dmgDone));
                            }
                        }
                    }
//                    System.out.println(pirateShip);
                    break;
                case "Repair":
                    int indexToRepair = Integer.parseInt(fight[1]);
                    int repair = Integer.parseInt(fight[2]);
                    if (indexToRepair < 0 || indexToRepair >= pirateShip.size()) {
                        break;
                    } else {
                        int repairIndex = repair + Integer.parseInt(pirateShip.get(indexToRepair));
                        if (repairIndex > maxHealth) {
                            repairIndex = maxHealth;
                        }
                        pirateShip.set(indexToRepair, String.valueOf(repairIndex));
//                        System.out.println(pirateShip);
                    }
                    break;
                case "Status":
                    int countPirate = 0;

                    for (int i = 0; i < pirateShip.size(); i++) {
                        int sectionHealth = Integer.parseInt(pirateShip.get(i));
                        if (sectionHealth < 0.2 * maxHealth) {
                            countPirate++;
                        }

                    }
                    System.out.printf("%d sections need repair.", countPirate);
                    System.out.println();
                    break;
                case "Retire":
                    System.out.printf("Pirate ship status: %d", status(pirateShip));
                    System.out.println();
                    System.out.printf("Warship status: %d", status(marines));
                    flag = false;
                    break;
            }
        }
    }

    public static ArrayList<String> addShip(Scanner scanner) {
        String[] index = scanner.nextLine().split(">");
        return new ArrayList<>(Arrays.asList(index));
    }
    public static int status(ArrayList<String>ship){
        int shipSum = 0;
        for (String s : ship) {
            int currentHealth = Integer.parseInt(s);
           shipSum += currentHealth;
        }
        return shipSum;


    }
}
