package com.plane.core.objs;

public abstract class LivingObject extends GameObject{
    public int health;
    public void damage(int amount,GameObject source){
        this.health-=amount;
    }
    public LivingObject(int health){
        this.health=health;
    }
}
