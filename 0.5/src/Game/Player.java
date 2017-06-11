package Game;

import Base.Item;
import Entitys.Person;

public class Player extends Person {
    private InventorySlot inventory;
    private AnimalSlot animals;
    private int up;
    public Player(int health, int damage, String name, int level, int money) {
        super(health, damage, name, level, money);
        this.up = 0;
        this.inventory = new InventorySlot();
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
        System.out.println("Your health is " + health);
        System.out.println("Your level is " + level);
        System.out.println("You have " + this.money + " money");
        System.out.println("You have " + this.up +" UP");
    }
    public void AddUp(int num){
        this.up += num;
        while(up>10){
            up -= 10;
            this.LevelUp();
        }
    }
    public void LevelUp(){
        this.level++;
        System.out.println("You have reached a new level! (Level "+ level +")");
        this.health += level * Data.LEVELUP_HEALTH_MUL;
        this.damage += level * Data.LEVELUP_DAMAGE_MUL;
        this.money += level * Data.LEVELUP_MONEY_MUL;
    }
    public void AddMoney(int money){
        this.money += money;
    }
    public void UseMoney(int money) { this.money -= money; }
    public void AddItem(Item item) {
        inventory.AddItem(item);
    }
    public InventorySlot GetInventory(){
        return this.inventory;
    }
    public void checkAnimals(){
        animals.checkAnimals();
    }
}
