package Events;

import Base.Event;
import Entitys.Animal;
import Game.Data;
import Game.Player;
import Game.Tools;

import java.util.Scanner;

public class Animals extends Event{
    private Animal animals [];

    @Override
    public boolean React(Player player) {
        Tools tool = new Tools(player);
        animals = new Animal[tool.random(Data.MIN_ANIMAL_EVENT,Data.MAX_ANIMAL_EVENT)];
        for (int i=0; i < animals.length; i++)
            animals[i] = tool.GenerateAnimal();
        for (Animal animal : animals)
            animal.ShowStats();
        System.out.println("You want to buy "+animals.length+" animals, for "+animals.length*Data.ANIMAL_PRICE_MUL+" gold?");
        Scanner s = new Scanner(System.in);
        String get;
        while(true) {
            get = s.next();
            if(player.getMoney() < animals.length * Data.ANIMAL_PRICE_MUL && (get.equals("y") || get.equals("yes"))){
                System.out.println("You dont have money to buy the animals..");
                get = "no";
            }
            if (get.equals("no") || get.equals("n")) {
                // fight animals
                return true;
            } else if (get.equals("yes") || get.equals("y")) {
                player.getAnimals().addAnimals(animals);
                System.out.println("Animals Bought!");
                break;
            }
        }
        return true;
    }
}
