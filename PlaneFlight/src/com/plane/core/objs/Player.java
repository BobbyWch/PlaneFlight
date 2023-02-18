package com.plane.core.objs;

import com.plane.Setting;
import com.plane.core.Game;
import com.plane.core.MathHelper;
import com.plane.core.objs.bullets.PlayerBullet;
import com.plane.ui.Renderer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends LivingObject implements KeyListener {
    public static int SPEED=7;
    private boolean left=false;
    private boolean right=false;
    private boolean up=false;
    private boolean down=false;
    private boolean fire=false;
    private int fireDelay=0;

    @Override
    public void render(Renderer r) {
        r.drawRect(x,y,width,height,false, Color.green);
        r.text("player  health:"+this.health,x,y);
    }
    @Override
    public void tick() {
        if (left) {
            x -= SPEED;
            if (x<1) x=1;
        }
        if (right) {
            x += SPEED;
            if (x>Setting.WIDTH-width) x= Setting.WIDTH-width;
        }
        if (up) {
            y-=SPEED;
            if (y<1) y=1;
        }
        if (down) {
            y += SPEED;
            if (y>Setting.HEIGHT-height) y= Setting.HEIGHT-height;
        }
        if (fire) fire();
        if (health<=0){
            Game.gg();
            Game.removeObj(this);
        }
    }
    public void fire(){
        if (--fireDelay<1){
            fireDelay=10;
//            if (Game.money<10)  //如果金钱超过10则改为随机子弹
                Game.addObject(new PlayerBullet(MathHelper.toCenter(x,width,PlayerBullet.WIDTH_BULLET),y));
//            else
//                Game.addObject(new PlayerBullet(MathHelper.rand(x, rightX()), y));  //  获得升级
        }
    }

    public Player(){
        super(Setting.PLAYER_HEALTH);
        this.width=70;
        this.height=70;
        this.x=(Setting.WIDTH-width)/2;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left=true;
                break;
            case KeyEvent.VK_RIGHT:
                right=true;
                break;
            case KeyEvent.VK_UP:
                up=true;
                break;
            case KeyEvent.VK_DOWN:
                down=true;
                break;
            case KeyEvent.VK_SPACE:
                fire=true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left=false;
                break;
            case KeyEvent.VK_RIGHT:
                right=false;
                break;
            case KeyEvent.VK_UP:
                up=false;
                break;
            case KeyEvent.VK_DOWN:
                down=false;
                break;
            case KeyEvent.VK_SPACE:
                fire=false;
                break;
        }
    }
}
