package com.plane.core.objs.bullets;

import com.plane.core.Game;
import com.plane.core.objs.GameObject;
import com.plane.ui.Renderer;

import java.awt.*;

//敌人子弹可以是正方形，后期绘制成圆的
public class HostileBullet extends Bullet{
    public static int WIDTH=10;
    public static int HEIGHT=10;
    public static int vBULLET=7;
    public static int DAMAGE=20;

    @Override
    public void render(Renderer r) {
        r.drawRect(this.x, this.y, WIDTH, HEIGHT, true, Color.PINK);

    }

    public boolean hit(GameObject o){
        return bottomY()>o.y&&rightX()>o.x&&x<o.rightX();  //判断敌人子弹是否与玩家相交
    }

    @Override
    public void tick() {
        super.tick();
        if(this.hit(Game.player)){
            Game.player.damage(DAMAGE, this);
            Game.removeObj(this);
        }
        this.y-=vBULLET;
    }
}
