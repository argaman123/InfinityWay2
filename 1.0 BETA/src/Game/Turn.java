package Game;


public class Turn {

    private Player player;

    public Turn(Player player) {
        this.player = player;
    }

    public boolean Start() throws InterruptedException {
        Tools t = new Tools(player);
        boolean keep = t.GenerateEvent().React(player);
        if (player.GetHealth() <= 0)
            keep = false;
        Thread.sleep(Data.MILLIS_TURN);
        return keep;
    }
}
