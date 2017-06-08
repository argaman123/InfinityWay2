package Game;

import Entitys.Animal;
import Entitys.Person;

public class AnimalSlot {
    private Animal[] animals;
    private int amount;
    public AnimalSlot(int amount, Person owner){
        this.animals = new Animal[100];
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
        }
    }
    public void Show(){
        for (Animal animal : animals){
            animal.ShowStats();
        }
    }
}
