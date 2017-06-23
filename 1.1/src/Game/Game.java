package Game;

import java.util.Scanner;

public class Game {
    private Scanner user;
    private Player player;

    public Game() {
        this.user = new Scanner(System.in);
        this.player = new Player(Data.PLAYER_HEALTH, Data.PLAYER_DAMAGE, Data.PLAYER_NAME, 1,
                Data.PLAYER_MONEY);
    }

    public int Start() throws InterruptedException {
        boolean run = true;
        String choice;
        while (run) {
            System.out.print("press (I)nventory / (S)tats / (M)ove > ");
            choice = user.nextLine();
            while (true) {
                if (choice.equalsIgnoreCase("i")) {
                    player.ShowInventory();
                    break;
                } else if (choice.equalsIgnoreCase("s")) {
                    player.ShowStats();
                    break;
                } else if (choice.equalsIgnoreCase("m")) {
                    run = (new Turn(player)).Start();
                    break;
                }
                System.out.print("(I/S/M) > ");
                choice = user.nextLine();
            }
        }
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        return 0;
    }
}
