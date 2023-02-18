package com.plane.core.objs.enemy;

import com.plane.core.Game;
import com.plane.core.LazyRun;
import com.plane.core.MathHelper;
import com.plane.core.move.MoveControl;
import com.plane.core.objs.bullets.HostileBullet;
import com.plane.ui.Renderer;

import java.awt.*;

/**
 * Tank应该在某一个x轴位置出生后，向下移动一段距离并停止，然后发子弹
 */
public class Tank extends Enemy implements LazyRun {
    public static final int HEALTH=1200;
    public static float SPEED=0.5f;
    public static int WIDTH=90;
    public static int HEIGHT=90;
    public static int DAMAGE=500;
//    public boolean fire;

    private final MoveControl move;
    public Tank(int health, int x,int y){
        super(health,x,y);
        width = WIDTH;
        height = HEIGHT;
        move=new MoveControl(this,SPEED,MoveControl.DOWN);
    }

    @Override
    public void render(Renderer r) {
        r.drawRect(this.x, this.y, width, height, false, Color.ORANGE);
        if (health<healthMax){
            r.healthBar(this);
        }
    }

    @Override
    public void tick() {
        move.standBy();
        if (isCover(Game.player)) {
            Game.player.damage(DAMAGE, this);
            Game.removeObj(this);
        }
        if (health<=0){
            Game.removeObj(this);
        }
    }

    public void fire(){
        Game.addObject(new HostileBullet(MathHelper.rand(this.x+10, this.rightX()-10), y));  //生成随机子弹
    }

    @Override
    public void lazyRun() {
        fire();
    }
}
