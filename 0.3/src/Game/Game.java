package Game;

import java.util.Scanner;

public class Game {
    private Scanner user;
    private Player player;
    public Game() {
        this.user = new Scanner(System.in);
        this.player = new Player(Data.PLAYER_HEALTH,Data.PLAYER_DAMAGE,Data.PLAYER_NAME,1,Data.PLAYER_MONEY);
    }
    public int Start(){
        boolean run = true;
        String choice;
        while(run){
            System.out.print("press (I)nventory / (S)tats / (Any Key) Move > ");
            choice = user.next();
            switch (choice) {
                case "i":
                case "inventory":
                    player.ShowInventory();
                    break;
                case "s":
                case "stats":
                    player.ShowStats();
                    break;
                case "\n":
                default:
                    run = (new Turn(player)).Start();
                    break;
            }
        }
        return 0;
    }
}
