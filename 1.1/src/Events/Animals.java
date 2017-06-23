package Events;

import Base.Entity;
import Base.Event;
import Entitys.Animal;
import Game.Data;
import Game.Fight;
import Game.Player;
import Game.Tools;

import java.util.Scanner;

public class Animals extends Event {

    @Override
    public boolean React(Player player) throws InterruptedException {
        Tools tool = new Tools(player);
        int max;
        if (player.GetLevel() < Data.MAX_ANIMAL_EVENT)
            max = Data.MAX_ANIMALEVENT_UNDER10(player.GetLevel());
        else
            max = Data.MAX_ANIMAL_EVENT;
        Animal[] animals = new Animal[tool.random(Data.MIN_ANIMAL_EVENT, max)];
        for (int i = 0; i < animals.length; i++)
            animals[i] = tool.GenerateAnimal();
        System.out.print("Do you want to buy ");
        for (int i = 0; i < animals.length - 1; i++) {
            animals[i].ShowStats();
            System.out.println(", ");
        }
        animals[animals.length - 1].ShowStats();
        Scanner s = new Scanner(System.in);
        System.out.print(" - for " + Data.ANIMAL_PRICE(animals.length) + " gold?");
        String get;
        while (true) {
            System.out.print("(Y/N) > ");
            get = s.nextLine();
            if (player.GetMoney() < Data.ANIMAL_PRICE(animals.length) && get.equalsIgnoreCase("y")) {
                System.out.println("You dont have money to buy the animals..");
                get = "n";
            }
            if (get.equalsIgnoreCase("n")) {
                Entity players[] = player.GetPlayers();
                Fight f = new Fight(players, animals, players.length, animals.length);
                int result = f.Start(animals.length);
                player.CheckAnimals();
                if (result == 0)
                    return false;
                else if (result == 1) {
                    player.AddUp(Data.GET_ANIMALUP(animals.length));
                    return true;
                } else
                    return true;
            } else if (get.equalsIgnoreCase("y")) {
                player.AddAnimals(animals);
                player.UseMoney(Data.ANIMAL_PRICE(animals.length));
                if (animals.length == 1)
                    System.out.println("Animal Bought!");
                else
                    System.out.println("Animals Bought!");
                break;
            }
        }
        return true;
    }
}
