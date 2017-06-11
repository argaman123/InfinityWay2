package Base;

import Game.Player;

import java.util.Scanner;

public abstract class Item{
    protected int cost, amount;
    protected String name;
    public Item(){
        this.amount = 1;
    }
    public int GetCost(){return cost;}
    public void Show(){
        if (amount == 1)
            System.out.print("1 "+ name);
         else
            System.out.print(amount+" "+name+"s");
    }
    public abstract void Activate(Player player);
    public void SetCost(int cost) {
        this.cost = cost;
    }
    public String GetName(){
        return name;
    }
    public void AddItem(Item item){
        amount++;
        cost += item.GetCost();
    }
}
