package Game;

import Base.Event;
import Base.Item;
import Entitys.Animal;
import Entitys.Enemy;
import Entitys.Person;
import Gems.*;

public class Tools {
    Person player;
    public Tools(Person player){this.player = player;}
    public Event RandomEvent(){return null;}
    public Enemy GenerateEnemy(){return null;}
    public Person GeneratePerson(){return null;}
    public Item GenerateItem(){return null;}
    public Animal GenerateAnimal(){return null;}
}
