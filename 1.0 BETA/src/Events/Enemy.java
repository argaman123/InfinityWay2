package Events;

import Base.Entity;
import Base.Event;
import Game.Data;
import Game.Fight;
import Game.Player;
import Game.Tools;

import java.util.Scanner;

public class Enemy extends Event {

    @Override
    public boolean React(Player player) throws InterruptedException {
        Tools t = new Tools(player);
        System.out.println("You have been stopped by an enemy!");
        Entitys.Enemy enemy = t.GenerateEnemy();
        Entity players[] = player.GetPlayers();
        Entity enemys[] = {enemy};
        Fight f = new Fight(players, enemys, players.length, enemys.length);
        int status = f.Start(1);
        if (status == 0)
            return false;
        if (status == 1)
            player.AddUp(Data.ENEMYKILL_UP);
        else {
            Scanner s = new Scanner(System.in);
            System.out.print("The enemy doesn't want you to kill him,\n" +
                    "he will give you money if you will let him leave!");
            String in;
            while (true) {
                System.out.print("(Y/N) > ");
                in = s.nextLine();
                if (in.equalsIgnoreCase("y")) {
                    int m = t.random(Data.MIN_ENEMYKILL_MONEY, Data.MAX_ENEMYKILL_MONEY);
                    System.out.println("The enemy is very thankful for that, and he gives you " +
                            m + " gold!");
                    player.AddMoney(m);
                    break;
                } else if (in.equalsIgnoreCase("n")) {
                    System.out.println("You disagree.");
                    status = f.Start(1);
                    if (status == 0)
                        return false;
                    if (status == 1)
                        player.AddUp(Data.ENEMYKILL_UP);
                    else
                        System.out.println("The enemy ran away!");
                    break;
                }
            }
        }
        return true;
    }
}
