package Events;

import Base.Entity;
import Base.Event;
import Entitys.Animal;
import Game.Data;
import Game.Fight;
import Game.Player;
import Game.Tools;

import java.util.Scanner;

public class Animals extends Event{
    private Animal animals [];

    @Override
    public boolean React(Player player) {
        Tools tool = new Tools(player);
        int max;
        if(player.getLevel()<10)
            max = player.getLevel() + Data.MAX_ANIMAL_UNDER10_ADD;
        else
            max = Data.MAX_ANIMAL_EVENT;
        animals = new Animal[tool.random(Data.MIN_ANIMAL_EVENT,max)];
        for (int i=0; i < animals.length; i++)
            animals[i] = tool.GenerateAnimal();
        for (Animal animal : animals)
            animal.ShowStats();
        System.out.println("You want to buy "+animals.length+" animals, for "+animals.length*Data.ANIMAL_PRICE_MUL+" gold? (Y/N)");
        Scanner s = new Scanner(System.in);
        String get;
        while(true) {
            get = s.next();
            if(player.getMoney() < animals.length * Data.ANIMAL_PRICE_MUL && (get.equals("y"))){
                System.out.println("You dont have money to buy the animals..");
                get = "n";
            }
            if (get.equals("n")) {
                int amount = player.getAnimals().getLength();
                int playerlen = amount+1;
                Entity players[] = new Entity[playerlen];
                players[0] = player;
                Entity panimals[] = player.getAnimals().getAnimals();
                for(int i=1; i<players.length; i++)
                    players[i] = panimals[i-1];
                Fight f = new Fight(players,this.animals,playerlen,this.animals.length);
                int result = f.Start(animals.length);
                player.checkAnimals();
                if(result == 0)
                    return false;
                else if (result == 1){
                    player.AddUp(this.animals.length * Data.GET_UP_MUL);
                    System.out.println("You earned " +
                            this.animals.length * Data.GET_UP_MUL + " UP!");
                    return true;
                } else
                    return true;
            } else if (get.equals("y")) {
                player.getAnimals().addAnimals(animals);
                player.UseMoney(animals.length * Data.ANIMAL_PRICE_MUL);
                System.out.println("Animals Bought!");
                break;
            }
        }
        return true;
    }
}
