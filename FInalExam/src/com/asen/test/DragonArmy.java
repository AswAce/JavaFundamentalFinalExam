package com.asen.test;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Dragons>> types = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            String[] split = command.split(" ");
            String type = split[0];
            String name = split[1];
            int dmg = 0;
            int health = 0;
            int armor = 0;
            if (!split[2].equals("null")) {
                dmg = Integer.parseInt(split[2]);
            }
            if (split[2].equals( "null")) {
                dmg = 45;
            }
            if (!split[3].equals("null")) {
                health = Integer.parseInt(split[3]);
            }
            if (split[3].equals( "null")) {
                health = 250;
            }
            if (!split[4].equals( "null")) {
                armor = Integer.parseInt(split[4]);
            }
            if (split[4].equals( "null")) {
                armor = 10;
            }
            Dragons dragon = new Dragons(name, dmg, health, armor);
            Map<String, Dragons> currentDragon = types.get(type);
            if (currentDragon == null) {
                currentDragon = new HashMap<>();
            }
            currentDragon.put(name, dragon);
            types.put(type, currentDragon);


        }
        types.
                entrySet().
                stream().
                forEach(e -> {
                    double ar = sumMiddle(e.getValue(), "armor");
                    double dmg=sumMiddle(e.getValue(),"damage");
                    double health=sumMiddle(e.getValue(),"health");
                    System.out.println(String.format("%s::(%.2f/%.2f/%.2f)",e.getKey(),dmg,health,ar));
                    e.getValue().
                            entrySet().
                            stream().
                            sorted((a1,a2)->a1.getKey().compareTo(a2.getKey())).
                            forEach(z-> System.out.println(z.getValue().toString()));
                });
    }

    private static double sumMiddle(Map<String, Dragons> value, String type) {
        double number = 0.0;
        for (Map.Entry<String, Dragons> dragonsEntry : value.entrySet()) {
            if (type.equals("armor")) {
                number += dragonsEntry.getValue().getArmor();
            }
            if (type.equals("damage")) {
                number += dragonsEntry.getValue().getDamage();
            } else if (type.equals("health")) {
                number += dragonsEntry.getValue().getHealth();
            }
        }
        return number/value.size();
    }
    public static class Dragons {
        private String name;
        private int damage;
        private int health;
        private int armor;

        public Dragons(String name, int damage, int health, int armor) {
            this.name = name;
            this.damage = damage;
            this.health = health;
            this.armor = armor;
        }

        public String getName() {
            return name;
        }

        public int getDamage() {
            return damage;
        }

        public int getHealth() {
            return health;
        }

        public int getArmor() {
            return armor;
        }

        @Override
        public String toString() {
            return  String.format("-%s -> damage: %s, health: %s, armor: %s",this.name,this.damage,this.health,this.armor);
        }
    }

}
