package Base;

import Game.Player;

import java.util.Scanner;

public abstract class Item{
    protected int cost, amount, name;

    public void Show(){
        System.out.println(amount+" "+name+"s");
    }

    /*public void React(Player player) {
        System.out.println("You want to buy "+amount+" "+name+"s?");
        Scanner s = new Scanner(System.in);
        String get;
        while(true){
            get =  s.next();
            if (get.equals("yes") || get.equals("y")){
                break;
            } else if (get.equals("no") || get.equals("n")){
                break;
            }
        }
    }
*/
    public abstract void Activate(Player player);
}
