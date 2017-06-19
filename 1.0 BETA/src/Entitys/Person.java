package Entitys;

import Base.Entity;
import Base.Item;
import Game.AnimalSlot;
import Game.InventorySlot;

public class Person extends Entity {
    protected InventorySlot inventory;
    protected AnimalSlot animals;
    protected int money;

    public Person(int health, int damage, String name, int level, int money) {
        super(health, damage, name, level);
        this.inventory = new InventorySlot(this);
        this.money = money;
        this.type = "Person";
        this.animals = new AnimalSlot(0, this);
    }

    public int GetMoney() {
        return money;
    }

    public InventorySlot GetInventory() {
        return this.inventory;
    }

    public void CheckAnimals() {
        animals.CheckAnimals();
    }

    public void AddAnimals(Animal ... animals){
        this.GetAnimals().AddAnimals(animals);
    }

    public void ShowInventory() {
        inventory.Show();
        animals.Show();
    }

    public boolean HaveInventory(){
        return inventory.getLength() != 0 || animals.GetLength() != 0;
    }

    public Entity[] GetPlayers() {
        CheckAnimals();
        int amount = GetAnimals().GetAnimals().length;
        int playerlen = amount + 1;
        Entity players[] = new Entity[playerlen];
        players[0] = this;
        Entity panimals[] = GetAnimals().GetAnimals();
        for (int i = 1; i < players.length; i++)
            players[i] = panimals[i - 1];
        return players;
    }

    public void AddItem(Item item) {
        inventory.AddItem(item);
    }

    public AnimalSlot GetAnimals() {
        return animals;
    }

    public void ShowStats(){
        System.out.println(name + "'s health is " + health);
        System.out.println(name + " is level " + level);
        System.out.println(name + " has " + this.money + " money");
    }

}
