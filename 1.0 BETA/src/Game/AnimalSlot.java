package Game;

import Base.Slot;
import Entitys.Animal;
import Entitys.Person;

public class AnimalSlot extends Slot {
    private Animal[] animals;
    private int amount;

    public AnimalSlot(int amount, Person owner) {
        this.animals = new Animal[Data.MAX_ANIMAL_SLOT];
        this.amount = amount;
        for (int i = 0; i < amount; i++)
            this.animals[i] = (new Tools(owner)).GenerateAnimal();
        this.emptys = new int[10];
        this.emptysAmount = 0;
    }

    public void AddAnimals(Animal ... animals) {
        int i = amount;
        while (i - amount < animals.length) {
            if (i == this.animals.length - 1) {
                if(emptysAmount > 0){
                    System.out.println("You have a small place in your packet, so you put the item in there.");
                    animals[emptys[emptysAmount-1]] = animals[i - amount];
                    emptysAmount--;
                    i++;
                    continue;
                } else {
                    System.out.println("You have no more place for animals.");
                    break;
                }
            }
            if (i == this.animals.length - 1)
                System.out.println("You have no more place for animals.");
            else {
                this.animals[i] = animals[i - amount];
                i++;
            }
        }
        amount = i;
    }

    public void Show() {
        if (amount == 0)
            System.out.println("and no animals.");
        else {
            System.out.print("and ");
            for (int i = 0; i < amount - 1; i++) {
                if (animals[i] == null)
                    continue;
                animals[i].ShowStats();
                System.out.println(", ");
            }
            if (animals[amount-1] != null)
                animals[amount - 1].ShowStats();
            System.out.println(".");
        }
    }

    public Animal[] GetAnimals() {
        Animal[] animals = new Animal[amount];
        for(int i = 0, j = 0; i < amount; i++){
            if (this.animals[i] == null) continue;
            animals[j] = this.animals[i];
            j++;
        }
        return animals;
    }

    public int GetLength() {
        return amount;
    }

    public void CheckAnimals() {
        for (int i = 0; i < amount; i++)
            if (animals[i].GetHealth() <= 0) Remove(i);
    }

    public void Remove(int animalNum){
        animals[animalNum] = null;
        amount--;
        emptys[emptysAmount] = animalNum;
        emptysAmount++;
    }

    public int GetIndex(String name){
        for(int i = 0; i < amount; i++){
            if (animals[i] == null) continue;
            if (animals[i].GetName().equalsIgnoreCase(name))
                return i;
        }
        return -1;
    }

    public Animal GetAnimal(int index){
        if (index >= amount) return null;
        return animals[index];
    }
}
