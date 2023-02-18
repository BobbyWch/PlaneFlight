package com.plane.core.objs.enemy;

import com.plane.Setting;
import com.plane.core.Game;
import com.plane.core.MathHelper;
import com.plane.core.objs.bullets.HostileBullet;
import com.plane.ui.Renderer;

import java.awt.*;

public class Tank extends Enemy{
    public static final int HEALTH=2000;
    public static int SPEED=1;
    public static int WIDTH=90;
    public static int HEIGHT=90;
    public static int DAMAGE=2000;
    public boolean fire;

    public Tank(int health, int x,int y){
        super(health,x,y);
        width = WIDTH;
        height = HEIGHT;
        fire=true;
    }

    @Override
    public void render(Renderer r) {
        r.drawRect(this.x, this.y, width, height, false, Color.ORANGE);
        r.text("health:"+health, this.x, this.y);
    }

    @Override
    public void tick() {
        y += SPEED;
        if (y> Setting.HEIGHT) {
            Game.removeObj(this);
            if (Game.money>10) Game.money-=10; //扣钱
            else Game.money=0;
        }
        if (isCover(Game.player)) {
            Game.player.damage(DAMAGE, this);
            Game.removeObj(this);
        }
        if (fire) fire();
    }

    public void fire(){
        Game.addObject(new HostileBullet(MathHelper.rand(this.x, this.rightX()), y));
    }
}
