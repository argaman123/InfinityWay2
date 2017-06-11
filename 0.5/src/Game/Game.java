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
            System.out.print("press (I)nventory / (S)tats / (M)ove > ");
            choice = user.next();
            while (true) {
                if(choice.equalsIgnoreCase("i")) {
                    player.ShowInventory();
                    break;
                } else if (choice.equalsIgnoreCase("s")) {
                    player.ShowStats();
                    break;
                } else if (choice.equalsIgnoreCase("m")){
                        run = (new Turn(player)).Start();
                        break;
                }
            }
        }
        System.out.println("You died!");
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        return 0;
    }
}
