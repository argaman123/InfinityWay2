package Game;

import Base.Item;
import Base.Slot;

public class InventorySlot extends Slot {
    private Item[] inventory;
    private int amount;
    public InventorySlot() {
        this.inventory = new Item[Data.MAX_INVENTORY];
        this.amount = 0;
    }
    public void Show(){
        if (amount == 0)
            System.out.println("You have no inventory.");
        else
            for(int i=0; i<amount; i++) {
                inventory[i].Show();
                System.out.println("");
            }
    }
    public boolean HavePlace(){
        return amount < inventory.length;
    }
    public void AddItem(Item item){
        for(int i=0; i < amount; i++)
            if (inventory[i].GetName().equals(item.GetName())) {
                inventory[i].AddItem(item);
                return;
            }
        inventory[amount] = item;
        amount++;
    }
}
