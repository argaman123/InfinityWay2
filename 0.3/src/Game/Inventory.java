package Game;

import Base.Item;

public class Inventory {
    private Item[] inventory;
    private int amount;
    public Inventory() {
        this.inventory = new Item[Data.MAX_INVENTORY];
        this.amount = 0;
    }
    public void Show(){

    }
}
