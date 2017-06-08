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
    public int random(int from, int to){
        Random rand = new Random();
        return rand.nextInt(to) + from;
    }
    public int randomPer(int ... nums){
        int sum = 0;
        int arr[] = new int[nums.length];
        for(int i = 0; i < arr.length; i++) {
            sum += nums[i];
            arr[i] = sum;
        }
        int rand = random(1,100);
        int i = 0;
        while(arr[i]<rand && i < arr.length) i++;
        return i;
    }
    public Event GenerateEvent(){
        Event events[] = Data.events;
        return events[randomPer(Data.ANIMALS_CHANCE, Data.ENEMY_CHANCE, Data.ITEM_CHANCE, Data.PERSON_CHANCE)];
    }
    public String GenerateName(){
        String s[] = {"Gorvald", "Trin", "Ingrad", "Brist", "Pown", "Hern"};
        return s[random(0,s.length-1)];
    }
    public Person GeneratePerson(){
        int plevel = player.getLevel()+1;
        int level = random(plevel-Data.MIN_PERSONLEVEL_SUB,plevel+Data.MAX_PERSONLEVEL_ADD),
                health = level * Data.PERSON_HEALTH_MUL, money = level * Data.PERSON_MONEY_MUL,
                damage = level + Data.PERSON_DAMAGE_ADD;
        String name = GenerateName();
        return new Person(health, damage, name, level, money);
    }
    public Item GenerateItem(){
        Item [] items = Data.items;
        for (Item item : items)
            if(item.GetCost() <= player.getMoney())
                if(random(0,Data.ITEM_FOUND_CHANCE) > 0) {
                    item.SetCost(random(item.GetCost()/Data.ITEM_MINCOST_DIV, item.GetCost() * Data.ITEM_MAXCOST_MUL));
                    return item;
                }
        return null;
    }
    public Animal GenerateAnimal(){
        int alevel = random(Data.MIN_ANIMAL_HEALTH, Data.MAX_ANIMAL_HEALTH);
        return new Animal(alevel,alevel,GenerateName()+"'s animal",alevel);
    }
    public Enemy GenerateEnemy(){
        int level = random(Data.MIN_ENEMYLEVEL, Data.MAX_ENEMYLEVEL);
        return new Enemy(level * Data.ENEMY_HEALTH_MUL,level + Data.ENEMY_DAMAGE_ADD,level);
    }
}
