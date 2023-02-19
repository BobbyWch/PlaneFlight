package com.plane.core.obj.enemy;

import com.plane.Setting;
import com.plane.core.Game;
import com.plane.core.LazyRun;
import com.plane.core.move.MoveControl;
import com.plane.core.obj.GameObject;
import com.plane.ui.Renderer;

import java.awt.*;

public class Soldier extends Enemy implements LazyRun {
    public static int HEALTH = 100;
    public static int SPEED=2;
    public static int WIDTH=40;
    public static int HEIGHT=40;
    public static int DAMAGE=200;

    @Override
    public void render(Renderer r) {
        r.drawRect(this.x, this.y, width, height, false, Color.BLUE);
        if (health<healthMax){
            r.healthBar(this);
        }
    }

    @Override
    public void tick() {
        move.move();
        if (y> Setting.HEIGHT){
            Game.removeObj(this);
        }
        if (isCover(Game.player)){
            Game.player.damage(DAMAGE,this);
            Game.removeObj(this);
        }
        if (health<=0) {
            Game.removeObj(this);
            Game.addMoney(10);
        }
    }
    private final MoveControl move;

    public Soldier(int health,int x,int y) {
        super(health,x,y);
        width=WIDTH;
        height=HEIGHT;
        move=new MoveControl(this,SPEED,MoveControl.DOWN);
    }

    @Override
    public void damage(int amount, GameObject source) {
        super.damage(amount, source);
    }

    @Override
    public void lazyRun() {
        //如果在player上面就追踪
        if (y<Game.player.y){
            move.turn(Game.player);
        }
    }
}
