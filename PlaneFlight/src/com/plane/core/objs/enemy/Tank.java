package com.plane.core.objs.enemy;

import com.plane.Setting;
import com.plane.core.Game;
import com.plane.core.objs.bullets.Bullet;
import com.plane.ui.Renderer;

import java.awt.*;

public class Tank extends Enemy{
    public static final int HEALTH=2000;
    public static int SPEED=1;
    public static int WIDTH=90;
    public static int HEIGHT=90;
    public static int DAMAGE=2000;

    public Tank(int health, int x,int y){
        super(health,x,y);
        width = WIDTH;
        height = HEIGHT;
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
            Game.money-=10; //扣钱
        }
        if (isCover(Game.player)){
            Game.player.damage(DAMAGE, this);
            Game.removeObj(this);
        }
    }
    public void fire(){
        //Bullet bullet = new
    }
}
