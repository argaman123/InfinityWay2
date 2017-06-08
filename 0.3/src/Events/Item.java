package Events;

import Base.Event;
import Game.Player;

public class Item extends Event {
    private Item item;

    @Override
    public boolean React(Player player) {
        return true;
    }
}
