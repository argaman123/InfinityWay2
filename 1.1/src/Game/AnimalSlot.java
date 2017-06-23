package Game;

import Base.Slot;
import Entitys.Animal;
import Entitys.Person;

import java.util.LinkedList;

public class AnimalSlot extends Slot {
    private LinkedList<Animal> animals;
    private int amount;

    public AnimalSlot(int amount, Person owner) {
        this.animals = new LinkedList<>();
        this.amount = amount;
        for (int i = 0; i < amount; i++)
            this.animals.add((new Tools(owner)).GenerateAnimal());
    }

    public void AddAnimals(Animal ... animals) {
        for(int i = 0; i < animals.length; i++,amount++) {
                this.animals.add(animals[i]);
        }
    }

    public void Show() {
        if (amount == 0)
            System.out.println("and no animals.");
        else {
            System.out.print("and ");
            for (int i = 0; i < amount - 1; i++) {
                animals.get(i).ShowStats();
                System.out.println(", ");
            }
            animals.get(amount - 1).ShowStats();
            System.out.println(".");
        }
    }

    public LinkedList<Animal> GetAnimals() {
        return animals;
    }

    public int GetLength() {
        return amount;
    }

    public void CheckAnimals() {
        int i = amount;
        while(i > 0) {
            if (animals.get(i - 1).GetHealth() <= 0)
                Remove(i - 1);
            i--;
        }
    }

    public int GetIndex(String name){
        for(int i = 0; i < amount; i++){
            if (animals.get(i).GetName().equalsIgnoreCase(name))
                return i;
        }
        return -1;
    }

    public Animal GetAnimal(int index){
        if (index >= amount) return null;
        return animals.get(index);
    }

    public void Remove(int index){
        amount--;
        animals.remove(index);
    }
}
