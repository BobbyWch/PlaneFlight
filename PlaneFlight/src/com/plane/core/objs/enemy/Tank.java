package com.plane.core.objs.enemy;

import com.plane.ui.Renderer;

public class Tank extends Enemy{
    public static final int HEALTH=2000;
    public Tank(int x,int y){
        super(HEALTH,x,y);
    }
    @Override
    public void render(Renderer r) {

    }

    @Override
    public void tick() {

    }
    public void fire(){

    }
}
