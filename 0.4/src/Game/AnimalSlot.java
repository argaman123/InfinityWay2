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
        while(i<animals.length){
            if(i == this.animals.length-1){
                System.out.println("You have no more place for animals.");
                break;
            }
            this.animals[i] = animals[i-amount];
            i++;
        }
    }
    public void Show(){
        for (Animal animal : animals){
            if (animal == null) break;
            animal.ShowStats();
        }
    }
}
