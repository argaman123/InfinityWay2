package Game;

import Base.Event;
import Base.Item;
import Entitys.Animal;
import Entitys.Enemy;
import Entitys.Person;

import java.util.Random;

public class Tools {
    private Person player;

    public Tools(Person player) {
        this.player = player;
    }

    public int random(int from, int to) {
        Random rand = new Random();
        return rand.nextInt(to+1) + from;
    }

    public int randomPer(int... nums) {
        int sum = 0;
        int arr[] = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            sum += nums[i];
            arr[i] = sum;
        }
        int rand = random(1, 100);
        int i = 0;
        while (arr[i] < rand && i < arr.length) i++;
        return i;
    }

    public Event GenerateEvent() {
        Event events[] = Data.events;
        return events[randomPer(Data.ANIMALS_CHANCE, Data.ENEMY_CHANCE, Data.ITEM_CHANCE, Data.PERSON_CHANCE)];
    }

    public String GeneratePersonName() {
        String names[] = Data.personNames;
        return names[random(0, names.length - 1)];
    }

    public String GenerateAnimalName(int level) {
        String names[] = Data.animalNames;
        if (level > 10)
            level = 10;
        return names[level - 1];
    }

    public Person GeneratePerson() {
        int plevel = player.GetLevel() + 1;
        int level = random(Data.MIN_PERSONLEVEL(plevel), Data.MAX_PERSONLEVEL(plevel)),
                health = Data.PERSON_HEALTH(level), money = Data.PERSON_MONEY(level),
                damage = Data.PERSON_DAMAGE(level);
        String name = GeneratePersonName();
        Person person = new Person(health, damage, name, level, money);
        Tools t = new Tools(person);
        Item item;
        for(int i = 0; i < level%3; i++){
            item = t.GenerateItem();
            if(item == null)
                continue;
            person.AddItem(item);
        }
        for(int i = 0; i < level % 3; i++){
            person.AddAnimals(t.GenerateAnimal());
        }
        return person;
    }

    public Item GenerateItem() {
        Item[] items = Data.items;
        Item item = null;
        if(player.GetMoney() > 0) {
            int maxMoney = random(1, player.GetMoney());
            for (int i = 0; i < items.length; i++)
                if (items[i].GetCost() <= maxMoney)
                    item = items[i];
            if (randomPer(Data.ITEM_FOUND_CHANCE, 100 - Data.ITEM_FOUND_CHANCE) == 0 && item != null)
                item.SetCost(random(Data.MIN_ITEMCOST(item.GetCost()),
                        Data.MAX_ITEMCOST(item.GetCost())));
        }
        return item;
    }

    public Animal GenerateAnimal() {
        int alevel = random(Data.MIN_ANIMAL_LEVEL, Data.MAX_ANIMAL_LEVEL(player.GetLevel()));
        return new Animal(alevel, alevel, GenerateAnimalName(alevel), alevel);
    }

    public Enemy GenerateEnemy() {
        int level = random(Data.MIN_ENEMYLEVEL, Data.MAX_ENEMYLEVEL(player.GetLevel()));
        return new Enemy(Data.ENEMY_HEALTH(level),
                Data.ENEMY_DAMAGE(level), level);
    }

}
