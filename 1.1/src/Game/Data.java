package Game;

import Base.Event;
import Base.Item;
import Events.Animals;
import Events.Enemy;
import Events.Person;
import Items.Gem;

public class Data {
    public static final Item items[] = {
            new Gem("Drister", 10),
            new Gem("Jenemite", 50),
            new Gem("Frostone", 100),
            new Gem("Hicrogin", 250),
            new Gem("Pandrome", 400),
            new Gem("Hyporilium", 450),
            new Gem("Ringold", 550),
            new Gem("Awrient", 650),
            new Gem("Solarius", 800),
            new Gem("OQiralium",1000)
    };

    public static final Event events[] = {
            new Animals(),
            new Enemy(),
            new Events.Item(),
            new Person()
    };

    public static final String itemNames[] = {
            "Drister", "Jenemite", "Frostone", "Hicrogin", "Pandrome",
            "Hyporilium", "Ringold", "Awrient", "Solarius", "OQiraalium"
    };

    public static final String personNames[] = {
            "Gorvald", "Trin", "Ingrad", "Brist", "Pown", "Hern"
    };

    public static final String animalNames[] = {
            "cat", "dog", "wolf", "fox", "snake", "crocodile", "bear", "tiger", "lion", "dragon"
    };

    public static int MAX_ANIMALEVENT_UNDER10(int playerLevel) {
        return playerLevel;
    }
    public static final int MIN_ANIMAL_EVENT = 1;
    public static final int MAX_ANIMAL_EVENT = 10;
    public static int ANIMAL_PRICE(int animalLength) {
        return animalLength * 3;
    }

    public static final int PLAYER_HEALTH = 10;
    public static final int PLAYER_DAMAGE = 3;
    public static final String PLAYER_NAME = "Player";
    public static final int PLAYER_MONEY = 10;

    public static int LEVELUP_HEALTH(int playerLevel) {
        return playerLevel * 2;
    }
    public static int LEVELUP_MONEY(int playerLevel) {
        return playerLevel * 2;
    }
    public static int LEVELUP_DAMAGE(int playerLevel) {
        return playerLevel;
    }

    public static final int MIN_ENEMYKILL_MONEY = 1;
    public static final int MAX_ENEMYKILL_MONEY = 10;
    public static final int ENEMYKILL_UP = 5;

    public static int MIN_PLAYERATTACK_DAMAGE(int playerDamage) {
        return playerDamage / 2;
    }
    public static int MAX_PLAYERATTACK_DAMAGE(int playerDamage) {
        return playerDamage;
    }

    public static final int MIN_ANIMAL_LEVEL = 1;
    public static int MAX_ANIMAL_LEVEL(int playerLevel) {
        return playerLevel + 2;
    }

    public static final int ANIMALS_CHANCE = 30;
    public static final int ENEMY_CHANCE = 10;
    public static final int ITEM_CHANCE = 30;
    public static final int PERSON_CHANCE = 30;

    public static int MIN_ITEMCOST(int itemCost) {
        return itemCost / 2;
    }
    public static int MAX_ITEMCOST(int itemCost) {
        return itemCost;
    }
    public static final int ITEM_FOUND_CHANCE = 80;

    public static int MIN_PERSONLEVEL(int playerLevelPlusOne) {
        return playerLevelPlusOne - 1;
    }
    public static int MAX_PERSONLEVEL(int playerLevelPlusOne) {
        return playerLevelPlusOne;
    }
    public static int PERSON_HEALTH(int personLevel) {
        return personLevel * 3;
    }
    public static int PERSON_MONEY(int personLevel) {
        return personLevel * 5;
    }
    public static int PERSON_DAMAGE(int personLevel) {
        return personLevel * 2;
    }

    public static final int MIN_ENEMYLEVEL = 1;
    public static int MAX_ENEMYLEVEL(int playerLevel) { return playerLevel; }
    public static int ENEMY_HEALTH(int enemyLevel) {
        return enemyLevel * 2;
    }
    public static int ENEMY_DAMAGE(int enemyLevel) {
        return enemyLevel + 2;
    }

    public static int GET_ANIMALUP(int animalLength) {
        return animalLength * 2;
    }

    public static final int MILLIS_TURN = 0;
    public static final int MILLIS_FIGHT = 2000;

    public static int PERSON_PAYMONEY(int personLevel) { return personLevel; }

    public static final int PERSON_FIGHTTURNS = 10;

    public static int PERSONKILL_UP(int personLevel){ return personLevel + 5; }
    public static int PERSONKILL_MONEY(int personLevel){ return personLevel; }

}
