package Entitys;

import Base.Entity;

public class Animal extends Entity {
    public Animal(int health, int damage, String name, int level){
        super(health,damage,name,level);
    }

    @Override
    public void ShowStats() {
        System.out.println(name + "'s animal has " + health + " health");
    }
}
