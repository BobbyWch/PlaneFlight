package com.plane.core.objs;

import com.plane.Setting;
import com.plane.ui.Renderer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends LivingObject implements KeyListener {
    public static int SPEED=10;
    private boolean left=false;
    private boolean right=false;
    private boolean up=false;
    private boolean down=false;
    private boolean fire=false;
    @Override
    public void render(Renderer r) {
        r.drawRect(x,y,width,height);
        r.text("player\nhealth:"+this.health,x,y);
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

    }

    public Player(){
        super(Setting.PLAYER_HEALTH);
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
