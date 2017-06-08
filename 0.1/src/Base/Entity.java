package Base;

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
        System.out.println(name+" is level " + level);
        System.out.println(name+" health is " + health);
    }
    public boolean Damaged(int damage){
        this.health -= damage;
        return this.health > 0;
    }
    public int GetHealth(){return this.health;}
    public int getDamage(){return damage;}
}
