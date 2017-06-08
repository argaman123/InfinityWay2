package Entitys;

import Base.Entity;
import Game.AnimalSlot;
import Game.Inventory;

public class Person extends Entity{
    protected Inventory inventory;
    protected AnimalSlot animals;
    protected int money;
    public Person(int health, int damage, String name, int level, int money) {
        super(health, damage, name, level);
        this.inventory = new Inventory();
        this.money = money;
        this.animals = new AnimalSlot(0,this);
    }
    public int getMoney(){return money;}
}
