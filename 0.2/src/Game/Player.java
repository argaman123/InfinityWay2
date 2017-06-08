package Game;

import Entitys.Person;

public class Player extends Person {
    private int level;
    private Inventory inventory;
    private AnimalSlot animals;
    public Player(int health, int level, int money) {
        super(health,3, "Your", 1, money);
        this.level = level;
        this.inventory = new Inventory();
        this.animals = new AnimalSlot(0,this);
    }
    public void ShowInventory(){
        inventory.Show();
        animals.Show();
    }

    public AnimalSlot getAnimals() {
        return animals;
    }

    @Override
    public void ShowStats(){
        System.out.println("You are level " + level);
        System.out.println("Your health is " + health);
        System.out.println("Your level is " + level);
        System.out.println("You have " + this.money + " money");
    }
}
