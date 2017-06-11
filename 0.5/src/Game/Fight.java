package Game;

import Base.Entity;
import Entitys.Person;

public class Fight {
     private Entity enemy[], player[];
     private int playerAmount;
     private int enemyAmount;
     public Fight(Entity player[], Entity enemy[], int playerAmount, int enemyAmount){
         this.player = player;
         this.enemy = enemy;
         this.playerAmount = playerAmount;
         this.enemyAmount = enemyAmount;
     }
     public int Start(int turns){
         int enemyD, playerD;
         while(playerAmount > 0 && enemyAmount > 0){
             if(turns-- == 0)
                 break;
             playerD = player[playerAmount-1].Attack();
             enemyD = enemy[enemyAmount-1].Attack();
             System.out.println(enemy[enemyAmount-1].getName()+
                     " attacked you with " + enemyD + " damage");
             System.out.println(player[playerAmount-1].getName() +
                     " attacked the enemy with " + playerD + " damage");
             if(!enemy[enemyAmount-1].Damaged(playerD)){
                 System.out.println(enemy[enemyAmount-1].getName() + " died!");
                 enemyAmount--;
             }
             if(!player[playerAmount-1].Damaged(enemyD)){
                 System.out.println(player[playerAmount-1].getName() + " died!");
                 playerAmount--;
             }
             /*
             if(!(enemyAmount == 0 || playerAmount == 0)) {
                 System.out.println("\nplayer amount " + playerAmount + ", name " + player[playerAmount - 1].getName() +
                         ", health " + player[playerAmount - 1].GetHealth());
                 System.out.println("enemy amount " + enemyAmount + ", name " + enemy[enemyAmount - 1].getName() +
                         ", health " + enemy[enemyAmount - 1].GetHealth() + "\n");
             }
             */
         }
         if(playerAmount == 0)
             return 0;
         else if(enemyAmount == 0)
             return 1;
         else
             return 2;
     }
}
