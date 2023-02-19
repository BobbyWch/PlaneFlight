package com.plane.core.obj.enemy;

import com.plane.core.obj.LivingObject;

public abstract class Enemy extends LivingObject {
    public Enemy(int health) {
        super(health);
    }
    public Enemy(int health,int x,int y) {
        super(health);
        this.x=x;
        this.y=y;
    }
}
