package Game;

import Base.Event;
import Base.Item;
import Entitys.Animal;
import Entitys.Person;
import Events.Animals;
import Gems.*;

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
        int  sum=0;
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
        Event events[] = {new Animals(), new Events.Enemy(), new Events.Person(), new Events.Item()};
        return events[randomPer(30, 20, 40,10)];
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
        Item [] items = new Item[]{
                new Drister(),
                new Jenemite(),
                new Frostone(),
                new Hicrogin(),
                new Pandrome(),
                new Hyporilium(),
                new Ringold(),
                new Awrient(),
                new Solarius(),
                new OQiralium()};
        int rand = random(1,player.getMoney());
        //must be changed when adding new minimum prices
        if(rand < 10 || player.getMoney() < 10) return null;
        for (Item item : items)
            if(item.getCost() < rand)
                return item;
        return null;
    }
    public Animal GenerateAnimal(){
        int plevel = player.getLevel()+2;
        int alevel = random(plevel-2,plevel+2);
        return new Animal(alevel,alevel,GenerateName()+"'s animal",alevel);
    }
}
