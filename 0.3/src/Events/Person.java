package Events;

import Base.Event;
import Game.Player;

public class Person extends Event{

    @Override
    public boolean React(Player player) {
        return true;
    }
}
