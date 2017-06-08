package Events;

import Base.Event;
import Game.Data;
import Game.Player;
import Game.Tools;

import java.util.Scanner;

public class Enemy extends Event{
    private Entitys.Enemy enemy;
    @Override
    public boolean React(Player player) {
        Tools t = new Tools(player);
        System.out.println("You have been stopped by an enemy!");
        this.enemy = t.GenerateEnemy();
        int damage = this.enemy.Attack();
        System.out.println("The Enemy hit you with "+ damage +" damage!");
        if (!player.Damaged(damage)) return false;
        if(enemy.GetHealth() <= 0){
            System.out.println("You killed the enemy!");
            player.AddUp(Data.ENEMYKILL_UP);
        } else {
            System.out.println("The enemy doesn't want you to kill him\n" +
                    "he will give you money if you will let him leave!(Y/N)");
            Scanner s = new Scanner(System.in);
            String in = s.next();
            while(true)
                if(in.equalsIgnoreCase("y")){
                    int m = t.random(Data.MIN_ENEMYKILL_MONEY, Data.MAX_ENEMYKILL_MONEY);
                    System.out.println("The enemy is very thankful for that, and he gives you " + m + " gold!");
                    player.AddMoney(m);
                    break;
                } else if(in.equalsIgnoreCase("n")){
                    int d = player.Attack();
                    System.out.println("You disagree, and you hit the enemy with "+ d +" damage.");
                    if(enemy.Damaged(d)){
                        System.out.println("The enemy managed to run away..");
                        break;
                    } else {
                        System.out.println("You killed the enemy!");
                        player.AddUp(Data.ENEMYKILL_UP);
                        break;
                    }
                }
        }
        return true;
    }
}
