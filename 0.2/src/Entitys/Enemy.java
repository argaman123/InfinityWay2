package Entitys;

import Base.Entity;

public class Enemy extends Entity {
    public Enemy(int health, int damage, int level) {
        super(health, damage, "Enemy", level);
    }

    @Override
    public void ShowStats() {

    }
}
