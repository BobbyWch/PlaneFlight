package com.plane.core.objs;

import com.plane.Setting;
import com.plane.core.MathHelper;
import com.plane.core.objs.bullets.PlayerBullet;
import com.plane.ui.GamePane;
import com.plane.ui.Renderer;

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

    public void Up(){
        level += level;
    }

    @Override
    public void render(Renderer r) {
        r.drawRect(x,y,width,height,false);
        r.text("player  health:"+this.health,x,y);
        r.text("level:"+this.level,x,y-15);
    }

    @Override
    public void tick() {
        if (left) x -= SPEED;
        if (right) x += SPEED;
        if (up) y -= SPEED;
        if (down) y += SPEED;
        if (fire) fire();
    }
    public void fire(){
        if (--fireDelay<1){
            fireDelay=15;
            GamePane.instance.addObject(new PlayerBullet(MathHelper.toCenter(x,width,PlayerBullet.WIDTH_BULLET),y));
        }
    }

    public Player(){
        super(Setting.PLAYER_HEALTH, Setting.LEVEL);
        this.width=100;
        this.height=100;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

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

    @Override
    public void damage(int amount, GameObject source) {
        health-=amount;
    }
}
