package Base;

import Game.Player;

import java.util.Scanner;

public abstract class Item{
    protected int cost, amount;
    protected String name;
    public Item(){
        this.amount = 1;
    }
    public int getCost(){return cost;}
    public void Show(){
        System.out.println(amount+" "+name+"s");
    }
    public abstract void Activate(Player player);
}
