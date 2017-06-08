package Entitys;

import Base.Entity;
import Game.Animals;
import Game.Inventory;

public class Person extends Entity{
    private Inventory inventory;
    private Animals animals;
    public Person(int health, int damage, String name, int level) {
        super(health, damage, name, level);
        this.inventory = new Inventory();
        this.animals = new Animals(0,this);
    }
}
