package Game;

import Base.Entity;
import Base.Item;
import Entitys.Person;

public class Player extends Person {
    private int up;

    public Player(int health, int damage, String name, int level, int money) {
        super(health, damage, name, level, money);
        this.up = 0;
        this.type = "Player";
        this.inventory = new InventorySlot(this);
        this.animals = new AnimalSlot(0, this);
    }

    @Override
    public void ShowStats() {
        System.out.println("Your health is " + health);
        System.out.println("Your level is " + level);
        System.out.println("You have " + this.money + " money");
        System.out.println("You have " + this.up + " UP");
    }

    public void AddUp(int num) {
        this.up += num;
        System.out.println("You earned " + num + " UP!");
        while (up > 10) {
            up -= 10;
            this.LevelUp();
        }
    }

    public void LevelUp() {
        this.level++;
        System.out.println("You have reached a new level! (Level " + level + ")");
        this.health += Data.LEVELUP_HEALTH(level);
        this.damage += Data.LEVELUP_DAMAGE(level);
        this.money += Data.LEVELUP_MONEY(level);
    }

    public void AddMoney(int money) {
        this.money += money;
    }

    public void UseMoney(int money) {
        this.money -= money;
    }


}
