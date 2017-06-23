package Base;

import Game.Player;

public abstract class Event {
    public abstract boolean React(Player player) throws InterruptedException;
}
