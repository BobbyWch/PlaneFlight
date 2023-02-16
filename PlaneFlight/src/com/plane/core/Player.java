package com.plane.core;

import com.plane.ui.Renderer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends GameObject implements KeyListener {
    private boolean left=false;
    private boolean right=false;
    private boolean up=false;
    private boolean down=false;
    private boolean fire=false;
    @Override
    public void render(Renderer r) {
        r.drawRect(x,y,width,height);
        r.text("player",x,y);
    }

    @Override
    public void tick() {
        if (left){
            x--;
        }
        if (right){
            x++;
        }
        if (up){
            y--;
        }
        if (down){
            y++;
        }
        if (fire){
            fire();
        }
    }
    public void fire(){

    }

    public Player(){
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
}
