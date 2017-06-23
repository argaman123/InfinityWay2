package Events;

import Base.Event;
import Game.Player;
import Game.Tools;

import java.util.Scanner;

public class Item extends Event {

    @Override
    public boolean React(Player player) {
        Base.Item item = (new Tools(player)).GenerateItem();
        if (item == null) {
            System.out.println("You found pieces of broken item..");
            return true;
        }
        System.out.print("Do you want to buy ");
        item.Show();
        Scanner s = new Scanner(System.in);
        System.out.print(" for " + item.GetCost() + " gold?");
        String get;
        while (true) {
            System.out.print("(Y/N) > ");
            get = s.nextLine();
            if (get.equalsIgnoreCase("y"))
                if (player.GetMoney() < item.GetCost()) {
                    System.out.println("You don't have enough money for that item..");
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
