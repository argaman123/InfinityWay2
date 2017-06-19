package Entitys;

import Base.Entity;

public class Animal extends Entity {
    public Animal(int health, int damage, String name, int level) {
        super(health, damage, name, level);
        this.type = "Animal";
    }

    @Override
    public void ShowStats() {
        System.out.print("a " + name + " that has " + health + " health");
    }

}
