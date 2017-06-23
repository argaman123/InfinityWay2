package Items;

import Base.Item;
import Game.Player;

public class Gem extends Item {
    public Gem(String name, int cost) {
        super();
        this.name = name;
        this.cost = cost;
    }

    @Override
    public void Activate(Player player) {

    }
}
