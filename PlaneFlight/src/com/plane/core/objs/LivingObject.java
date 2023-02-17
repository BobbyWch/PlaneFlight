package com.plane.core.objs;

public abstract class LivingObject extends GameObject{
    public int health;
    public int level;
    public abstract void damage(int amount,GameObject source);
    public LivingObject(int health, int level){
        this.health=health;
        this.level=level;
    }
}
