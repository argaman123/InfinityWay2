package Events;

import Base.Event;
import Game.Data;
import Game.Player;
import Game.Tools;

import java.util.Scanner;

public class Item extends Event {
    private Base.Item item;

    @Override
    public boolean React(Player player) {
        this.item = (new Tools(player)).GenerateItem();
        if(this.item == null){
            System.out.println("You found pieces of broken item..");
            return true;
        }
        System.out.println("Do you want to buy ");
        item.Show();
        System.out.println(" for "+item.GetCost()+" gold?(Y/N) ");
        Scanner s = new Scanner(System.in);
        String get = s.next();
        while(true) {
            if (get.equalsIgnoreCase("y"))
                if(player.getMoney() < item.GetCost()){
                    System.out.println("You don't have enough money for that item..");
                    get = "n";
                } else if(!player.GetInventory().HavePlace()) {
                    System.out.println("You don't have enough space on your inventory..");
                    get = "n";
                } else {
                    player.UseMoney(item.GetCost());
                    player.AddItem(item);
                    System.out.println("Item bought!");
                    break;
                }
            if (get.equalsIgnoreCase("n"))
                break;
        }
        return true;
    }
}
