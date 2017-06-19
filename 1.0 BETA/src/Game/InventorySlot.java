package Game;

import Base.Item;
import Base.Slot;
import Entitys.Person;

public class InventorySlot extends Slot {
    private Item[] inventory;
    private int amount;
    private Person owner;
    public InventorySlot(Person owner) {
        this.inventory = new Item[Data.MAX_INVENTORY];
        this.amount = 0;
        this.owner = owner;
        this.emptys = new int[10];
        this.emptysAmount = 0;
    }

    public void Show() {
        if (amount == 0) {
            if (owner.GetType().equals("Player"))
                System.out.println("You have no items,");
            else
                System.out.println(owner.GetName() + " has no items,");
        } else
            for (int i = 0; i < amount; i++) {
                if (inventory[i] == null)
                    continue;
                inventory[i].Show();
                System.out.println(",");
            }

    }

    public boolean HavePlace() {
        return amount < inventory.length;
    }

    public void AddItem(Item item) {
        for (int i = 0; i < amount; i++) {
            if (inventory[i] == null) continue;
            if (inventory[i].GetName().equals(item.GetName())) {
                inventory[i].AddItem(item);
                return;
            }
        }
        if(amount >= this.inventory.length) {
            if (emptysAmount > 0) {
                System.out.println("You have a small place in your packet, so you put the item in there.");
                inventory[emptys[emptysAmount - 1]] = item;
                emptysAmount--;
            }
        } else
            inventory[amount] = item;
        amount++;
    }

    public void Remove(int itemNum){
        inventory[itemNum] = null;
        amount--;
        emptys[emptysAmount] = itemNum;
        emptysAmount++;
    }

    public int getLength(){
        return amount;
    }

    public int GetIndex(String name){
        for(int i = 0; i < amount; i++){
            if (inventory[i] == null) continue;
            if (inventory[i].GetName().equalsIgnoreCase(name))
                return i;
        }
        return -1;
    }

    public Item GetItem(int index){
        if (index >= amount) return null;
        return inventory[index];
    }
}
