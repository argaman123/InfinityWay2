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
        System.out.println("random: "+rand+", i: "+i);
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
        int level = random(plevel-1,plevel+1), health = level * 10, money = level * 10, damage = level + 3;
        String name = GenerateName();
        return new Person(health, damage, name, level, money);
    }
    public Item GenerateItem(){
        Item [] items = Data.items;
        for (Item item : items)
            if(item.getCost() < player.getMoney())
                if(random(0,1) == 1)
                    return item;
        return null;
    }
    public Animal GenerateAnimal(){
        int alevel = random(Data.MIN_ANIMAL_HEALTH, Data.MAX_ANIMAL_HEALTH);
        return new Animal(alevel,alevel,GenerateName()+"'s animal",alevel);
    }
    public Enemy GenerateEnemy(){
        int level = random(1,5);
        return new Enemy(level*2,level,level);
    }
}
