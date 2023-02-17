package com.plane.core.objs.bullets;

import com.plane.ui.Renderer;

public class PlayerBullet extends Bullet{
    public static final int v_BULLET=30;
    public static final int WIDTH_BULLET=8;
    public static final int HEIGHT_BULLET=20;
    public PlayerBullet(int x,int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public void render(Renderer r) {
        r.drawRect(this.x,this.y,WIDTH_BULLET,HEIGHT_BULLET,true);
    }

    @Override
    public void tick() {
        this.y-=v_BULLET;
    }
}
