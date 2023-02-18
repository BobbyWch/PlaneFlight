package com.plane.core.objs.bullets;

import com.plane.core.Game;
import com.plane.core.objs.GameObject;
import com.plane.core.objs.enemy.Enemy;
import com.plane.ui.Renderer;

import java.awt.*;

public class PlayerBullet extends Bullet{
    public static final int v_BULLET=10;
    public static final int WIDTH_BULLET=8;
    public static final int HEIGHT_BULLET=20;
    public static final int DAMAGE=30;
    public PlayerBullet(int x,int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public void render(Renderer r) {
        r.drawRect(this.x,this.y,WIDTH_BULLET,HEIGHT_BULLET,true, Color.gray);
    }

    public boolean hit(GameObject o){
//        return y<=o.bottomY()&&rightX()>=o.x&&x<=o.rightX(); //判断子弹与敌人是否相交
        //提速
        return y<=o.y+o.height&&x+width>=o.x&&x<=o.x+o.width;
    }
    @Override
    public void tick() {
        super.tick();
        for (Enemy e: Game.enemies){
            if (this.hit(e)){
                e.damage(DAMAGE,this);
                Game.removeObj(this);
                break;
            }
        }
        this.y-=v_BULLET;
    }
}
