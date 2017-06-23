package Game;

import Base.Item;
import Base.Slot;
import Entitys.Person;

import java.util.LinkedList;

public class InventorySlot extends Slot {
    private LinkedList<Item> inventory;
    private int amount;
    private Person owner;
    public InventorySlot(Person owner) {
        this.inventory = new LinkedList<>();
        this.amount = 0;
        this.owner = owner;
    }

    public void Show() {
        if (amount == 0) {
            if (owner.GetType().equals("Player"))
                System.out.println("You have no items,");
            else
                System.out.println(owner.GetName() + " has no items,");
        } else
            for (int i = 0; i < amount; i++) {
                inventory.get(i).Show();
                System.out.println(",");
            }
    }

    public void AddItem(Item item) {
        for (int i = 0; i < amount; i++) {
            if (inventory.get(i).GetName().equals(item.GetName())) {
                inventory.get(i).AddItem(item);
                return;
            }
        }
        inventory.add(item);
        amount++;
    }

    public int getLength(){
        return amount;
    }

    public int GetIndex(String name){
        for(int i = 0; i < amount; i++){
            if (inventory.get(i).GetName().equalsIgnoreCase(name))
                return i;
        }
        return -1;
    }

    public Item GetItem(int index){
        if (index >= amount) return null;
        return inventory.get(index);
    }

    public LinkedList<Item> GetInventory(){
        return inventory;
    }

    public void Remove(int index){
        amount--;
        inventory.remove(index);
    }
}
