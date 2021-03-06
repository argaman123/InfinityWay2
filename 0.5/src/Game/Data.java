package Game;

import Base.Event;
import Base.Item;
import Events.Animals;
import Events.Enemy;
import Events.Person;
import Gems.*;

public class Data {
    public static final Item items[] = {
            new Drister(),
            new Jenemite(),
            new Frostone(),
            new Hicrogin(),
            new Pandrome(),
            new Hyporilium(),
            new Ringold(),
            new Awrient(),
            new Solarius(),
            new OQiralium()
    };

    public static final Event events[] = {
            new Animals(),
            new Enemy(),
            new Events.Item(),
            new Person()
    };

    public static final int MAX_INVENTORY = 10;
    public static final int MAX_ANIMAL_SLOT = 10;
    public static final int MIN_ANIMAL_EVENT = 1;
    public static final int MAX_ANIMAL_EVENT = 10;
    public static final int ANIMAL_PRICE_MUL = 3;
    public static final int PLAYER_HEALTH = 10;
    public static final int PLAYER_DAMAGE = 3;
    public static final String PLAYER_NAME = "Player";
    public static final int PLAYER_MONEY = 10;
    public static final int LEVELUP_HEALTH_MUL = 2;
    public static final int LEVELUP_DAMAGE_MUL = 1;
    public static final int LEVELUP_MONEY_MUL = 5;
    public static final int MIN_ENEMYKILL_MONEY = 1;
    public static final int MAX_ENEMYKILL_MONEY = 10;
    public static final int ENEMYKILL_UP = 5;
    public static final int MIN_PLAYERATTACK_DAMAGE = 1;
    public static final int MAX_PLAYERATTACK_DAMAGE_ADD = 0;
    public static final int MIN_ANIMAL_HEALTH = 1;
    public static final int MAX_ANIMAL_HEALTH = 5;
    public static final int ANIMALS_CHANCE = 30;
    public static final int ENEMY_CHANCE = 10;
    public static final int ITEM_CHANCE = 20;
    public static final int PERSON_CHANCE = 40;
    public static final int ITEM_MINCOST_DIV = 2;
    public static final int ITEM_MAXCOST_MUL = 1;
    public static final int ITEM_FOUND_CHANCE = 3;
    public static final int MIN_PERSONLEVEL_SUB = 1;
    public static final int MAX_PERSONLEVEL_ADD = 1;
    public static final int PERSON_HEALTH_MUL = 3;
    public static final int PERSON_MONEY_MUL = 5;
    public static final int PERSON_DAMAGE_ADD = 3;
    public static final int MIN_ENEMYLEVEL = 1;
    public static final int MAX_ENEMYLEVEL = 5;
    public static final int ENEMY_HEALTH_MUL = 2;
    public static final int ENEMY_DAMAGE_ADD = 3;
    public static final int MAX_ANIMAL_UNDER10_ADD = 0;
    public static final int GET_UP_MUL = 1;
}
