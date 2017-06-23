package Events;

import Base.Entity;
import Base.Event;
import Game.Data;
import Game.Fight;
import Game.Player;
import Game.Tools;

import java.util.Scanner;

public class Person extends Event {
    private Player player;
    private Entitys.Person person;
    // 0 - did nothing
    // 1 - end his turn
    // 2 - died
    private int Pay(){
        if (player.GetMoney() < Data.PERSON_PAYMONEY(person.GetLevel())) {
            System.out.println("You don't enough money to pay..");
            return 0;
        } else {
            player.UseMoney(Data.PERSON_PAYMONEY(person.GetLevel()));
            System.out.println("You paid " + Data.PERSON_PAYMONEY(person.GetLevel()) +
                    " gold to the person, now he lets you go.");
            return 1;
        }
    }

    private int Buy(){
        Scanner s = new Scanner(System.in);
        String in;
        if(person.HaveInventory()) {
            System.out.print("Enter name of item or animal you want to buy > ");
            in = s.nextLine();
            int itemI = person.GetInventory().GetIndex(in);
            int animalI = person.GetAnimals().GetIndex(in);
            if (itemI != -1) {
                int cost = person.GetInventory().GetItem(itemI).GetCost();
                if (cost <= player.GetMoney()) {
                    player.UseMoney(cost);
                    player.AddItem(person.GetInventory().GetItem(itemI));
                    System.out.println("You bought the " + in + "! for " + cost + " gold.");
                    return 1;
                } else {
                    System.out.println("You don't have enough money to buy the " + in);
                    return 0;
                }
            } else if (animalI != -1) {
                int cost = person.GetAnimals().GetAnimal(animalI).GetLevel();
                if (cost <= player.GetMoney()) {
                    player.UseMoney(cost);
                    player.AddAnimals(person.GetAnimals().GetAnimal(animalI));
                    System.out.println("You bought the " + in + "! for " + cost + " gold.");
                    return 1;
                } else {
                    System.out.println("You don't have enough money to buy the " + in);
                    return 0;
                }
            } else {
                System.out.println(person.GetName() + " has no such item or animal!");
                return 0;
            }
        } else {
            System.out.println(person.GetName() + " doesn't has any item or animal!");
            return 0;
        }
    }

    private int Sell(){
        Scanner s = new Scanner(System.in);
        String in;
        if(player.HaveInventory()){
            System.out.print("Enter name of item or animal you want to sell > ");
            in = s.nextLine();
            int itemI = player.GetInventory().GetIndex(in);
            int animalI = player.GetAnimals().GetIndex(in);
            if (itemI != -1){
                int cost = player.GetInventory().GetItem(itemI).GetCost();
                if(cost <= person.GetMoney()){
                    player.AddMoney(cost);
                    player.GetInventory().Remove(itemI);
                    System.out.println("You sold the "+ in +"! and you got " + cost + " gold.");
                    return 1;
                } else {
                    System.out.println(person.GetName() + " doesn't has enough money to buy the " + in);
                    return 0;
                }
            } else if (animalI != -1){
                int cost = player.GetAnimals().GetAnimal(animalI).GetLevel();
                if(cost <= person.GetMoney()){
                    player.AddMoney(cost);
                    player.GetAnimals().Remove(animalI);
                    System.out.println("You sold the "+ in + "! and you got " + cost + " gold.");
                    return 1;
                } else {
                    System.out.println(person.GetName() + " doesn't has enough money to buy the " + in);
                    return 0;
                }
            } else {
                System.out.println("You have no such item or animal!");
                return 0;
            }
        } else{
            System.out.println("You dont have any item, or animal..");
            return 0;
        }
    }

    private int Fight() throws InterruptedException {
        Entity[] players = player.GetPlayers(), enemys = person.GetPlayers();
        Fight fight = new Fight(players,enemys,players.length,enemys.length);
        int result = fight.Start(Data.PERSON_FIGHTTURNS);
        if (result == 0) {
            return 2;
        } else if (result == 1){
            player.AddUp(Data.PERSONKILL_UP(person.GetLevel()));
            player.AddMoney(Data.PERSONKILL_MONEY(person.GetLevel()));
            System.out.println("You got " + Data.PERSONKILL_MONEY(person.GetLevel())+ " gold!");
            return 1;
        } else {
            System.out.println("The person ran away!");
            return 1;
        }
    }

    @Override
    public boolean React(Player player) throws InterruptedException {
        Tools t = new Tools(player);
        this.player = player;
        this.person = t.GeneratePerson();
        Scanner s = new Scanner(System.in);
        String in;
        System.out.println(person.GetName() + " level " + person.GetLevel()
                + " stopped you.");
        System.out.println("He has " + person.GetHealth() + " health, " +
                person.GetMoney() + " gold.");
        person.ShowInventory();
        player.ShowStats();
        player.ShowInventory();
        System.out.print("What would you like to do? ((P)ay / (B)uy / (S)ell / (F)ight) > ");
        in = s.nextLine();
        int status;
        while(true){
            status = 0;
            if(in.equalsIgnoreCase("p"))
                status = Pay();
            else if (in.equalsIgnoreCase("b"))
                status = Buy();
            else if (in.equalsIgnoreCase("s"))
                status = Sell();
            else if (in.equalsIgnoreCase("f"))
                status = Fight();
            if (status == 1) return true;
            else if (status == 2) return false;
            System.out.print("(P/B/S/F) > ");
            in = s.nextLine();
        }
    }
}
