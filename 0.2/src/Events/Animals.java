package Events;

import Base.Event;
import Entitys.Animal;
import Game.Player;
import Game.Tools;

import java.util.Scanner;

public class Animals extends Event{
    private Animal animals [];

    @Override
    public void React(Player player) {
        Tools tool = new Tools(player);
        animals = new Animal[tool.random(1,10)];
        for (int i=0; i < animals.length; i++)
            animals[i] = tool.GenerateAnimal();
        for (Animal animal : animals)
            animal.ShowStats();
        System.out.println("You want to buy "+animals.length+" animals, for "+animals.length*3+" gold?");
        Scanner s = new Scanner(System.in);
        String get;
        while(true) {
            get = s.next();
            if(player.getMoney() < animals.length * 3 && (get.equals("y") || get.equals("yes"))){
                System.out.println("You dont have money to buy the animals..");
                get = "no";
            }
            if (get.equals("no") || get.equals("n") || player.getMoney() < animals.length * 3) {
                //fight animals
                break;
            } else if (get.equals("yes") || get.equals("y")) {
                player.getAnimals().addAnimals(animals);
                System.out.println("Animals Bought!");
                break;
            }
        }
    }
}
