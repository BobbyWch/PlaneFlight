package com.plane.core.objs;

public abstract class LivingObject extends GameObject{
    public int health;
    public abstract void damage(int amount,GameObject source);
    public LivingObject(int health){
        this.health=health;
    }
}
