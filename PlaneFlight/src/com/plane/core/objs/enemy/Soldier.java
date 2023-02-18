package com.plane.core.objs.enemy;

import com.plane.Setting;
import com.plane.core.Game;
import com.plane.core.objs.GameObject;
import com.plane.ui.Renderer;

import java.awt.*;

public class Soldier extends Enemy{
    public static int HEALTH = 200;
    public static int SPEED=2;
    public static int WIDTH=30;
    public static int HEIGHT=30;
    public static int DAMAGE=200;

    @Override
    public void render(Renderer r) {
        r.drawRect(this.x, this.y, width, height, false, Color.BLUE);
        r.text("health:" + health, this.x, this.y);
    }

    @Override
    public void tick() {
        y += SPEED;
        if (y> Setting.HEIGHT){
            Game.removeObj(this);
            Game.money-=5;
        }
        if (isCover(Game.player)){
            Game.player.damage(DAMAGE,this);
            Game.removeObj(this);
        }
        if (health<0) {
            Game.removeObj(this);
            Game.money+=10;
        }
    }

    public Soldier(int health,int x,int y) {
        super(health,x,y);
        width=WIDTH;
        height=HEIGHT;
    }

    @Override
    public void damage(int amount, GameObject source) {
        super.damage(amount, source);
    }
}
