package Game;

import Base.Entity;
import Entitys.Person;

public class Player extends Person {
    private int level, money;
    private Inventory inventory;
    private Animals animals;
    public Player(int health, int level, int money) {
        super(health,3, "Your", 1);
        this.money = money;
        this.level = level;
        this.inventory = new Inventory();
        this.animals = new Animals(0,this);
    }
    public void ShowInventory(){
        inventory.Show();
        animals.Show();
    }
    @Override
    public void ShowStats(){
        System.out.println("You are level " + level);
        System.out.println("Your health is " + health);
        System.out.println("Your level is " + level);
        System.out.println("You have " + money + " money");
    }
}
