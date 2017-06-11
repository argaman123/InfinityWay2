package Game;

import Base.Slot;
import Entitys.Animal;
import Entitys.Person;

public class AnimalSlot extends Slot{
    private Animal[] animals;
    private int amount;
    public AnimalSlot(int amount, Person owner){
        this.animals = new Animal[Data.MAX_ANIMAL_SLOT];
        this.amount = amount;
        for(int i = 0; i < amount; i++)
            this.animals[i] = (new Tools(owner)).GenerateAnimal();
    }
    public void addAnimals(Animal animals[]){
        int i=amount;
        while(i-amount<animals.length){
            if(i == this.animals.length-1){
                System.out.println("You have no more place for animals.");
                break;
            }
            this.animals[i] = animals[i-amount];
            i++;
        }
        amount = i;
    }
    public void Show(){
        if(amount == 0)
            System.out.println("You have no animals.");
        else
            for (int i = 0; i < amount; i++)
                animals[i].ShowStats();
    }
    public Animal[] getAnimals(){return animals;}
    public int getLength(){return amount;}
    public void checkAnimals(){
        for(int i = amount-1; i >= 0; i--, amount--)
            if(animals[i].GetHealth() > 0) break;
    }
}
