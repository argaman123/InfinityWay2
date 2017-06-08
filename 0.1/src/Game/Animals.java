package Game;

import Base.Entity;
import Entitys.Animal;
import Entitys.Person;

public class Animals {
    private Animal[] animals;
    private int amount;
    public Animals(int amount, Person owner){
        this.animals = new Animal[100];
        this.amount = amount;
        for(int i = 0; i < amount; i++)
            this.animals[i] = (new Tools(owner)).GenerateAnimal();
    }
    public void Show(){

    }
}
