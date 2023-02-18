package com.plane.core.objs.enemy;

import com.plane.core.Game;
import com.plane.core.objs.LivingObject;

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
