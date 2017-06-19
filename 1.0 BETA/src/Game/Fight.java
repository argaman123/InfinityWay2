package Game;

import Base.Entity;

public class Fight {
    private Entity enemy[], player[];
    private int playerAmount;
    private int enemyAmount;

    public Fight(Entity player[], Entity enemy[], int playerAmount, int enemyAmount) {
        this.player = player;
        this.enemy = enemy;
        this.playerAmount = playerAmount;
        this.enemyAmount = enemyAmount;
    }

    public int Start(int turns) throws InterruptedException {
        int enemyD, playerD;
        String playerName, enemyName;
        boolean hasPlayer = enemy[0].GetType().equals("Enemy") || enemy[0].GetType().equals("Person");
        while (playerAmount > 0 && enemyAmount > 0) {
            Thread.sleep(Data.MILLIS_FIGHT);
            if (turns-- == 0)
                break;
            playerD = player[playerAmount - 1].Attack(); // error caused by this line!
            enemyD = enemy[enemyAmount - 1].Attack();
            enemyName = enemy[enemyAmount - 1].GetName();
            if (playerAmount == 1)
                playerName = "You";
            else
                playerName = "Your " + player[playerAmount - 1].GetName();
            if (hasPlayer && enemyAmount != 1)
                enemyName = enemy[0].GetName() + "'s " + enemyName;
            if (enemyD == 0)
                System.out.println(enemyName + " missed the hit!");
            else
                System.out.println(enemyName +
                        " attacked you with " + enemyD + " damage");
            if (playerD == 0)
                System.out.println(playerName + " missed the hit!");
            else
                System.out.println(playerName +
                        " attacked the enemy with " + playerD + " damage");
            if (!enemy[enemyAmount - 1].Damaged(playerD)) {
                System.out.println(enemyName + " died!");
                enemyAmount--;
            }
            if (!player[playerAmount - 1].Damaged(enemyD)) {
                System.out.println(playerName + " died!");
                playerAmount--;
            }
        }
        if (hasPlayer)
            ((Player)(player[0])).CheckAnimals();
        if (playerAmount == 0)
            return 0;
        else if (enemyAmount == 0)
            return 1;
        else
            return 2;
    }
}
