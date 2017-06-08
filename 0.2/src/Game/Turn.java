package Game;


public class Turn {

    private Player player;
    public Turn(Player player) {
        this.player = player;
    }
    public boolean Start(){
        Tools t = new Tools(player);
        t.GenerateEvent().React(player);
        return true;
    }
}
