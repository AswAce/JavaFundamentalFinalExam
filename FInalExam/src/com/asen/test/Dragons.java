package com.asen.test;

public class Dragons {
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
