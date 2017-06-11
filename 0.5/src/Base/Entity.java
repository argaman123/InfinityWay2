package Base;

import Game.Data;
import Game.Tools;

import java.util.Random;

public abstract class Entity{
    protected int health, damage, level;
    protected String name;
    public Entity(int health, int damage, String name, int level){
        this.health = health;
        this.damage = damage;
        this.name = name;
        this.level = level;
    }
    public void ShowStats(){
        System.out.println(name + " is level " + level + ", and has " + health + " health");
    }
    public boolean Damaged(int damage){
        this.health -= damage;
        return this.health > 0;
    }
    public int GetHealth(){return this.health;}
    public int getLevel() {
        return level;
    }
    public String getName() {
        return name;
    }
    public int Attack(){
        Random rand = new Random();
        return rand.nextInt(damage+ Data.MAX_PLAYERATTACK_DAMAGE_ADD) + Data.MIN_PLAYERATTACK_DAMAGE;
    }
}
