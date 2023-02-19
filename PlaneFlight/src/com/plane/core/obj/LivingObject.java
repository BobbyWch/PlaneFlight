package com.plane.core.obj;

public abstract class LivingObject extends GameObject{
    public int health;
    public final int healthMax;
    public void damage(int amount,GameObject source){
        this.health-=amount;
    }
    public LivingObject(int health){
        this.health=health;
        this.healthMax=health;
    }
}
