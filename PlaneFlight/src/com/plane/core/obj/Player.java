package com.plane.core.obj;

import com.plane.Setting;
import com.plane.core.Game;
import com.plane.core.MathHelper;
import com.plane.core.obj.bullets.PlayerBullet;
import com.plane.ui.Renderer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Player extends LivingObject implements KeyListener {
    public static int SPEED_MAX =7;
    public static int FIRE_DELAY=8;
    private boolean left=false;
    private boolean right=false;
    private boolean up=false;
    private boolean down=false;
    public static boolean STRONGER=false;
    private int fireDelay=0;
    /**
     * 加速延迟，让加速减速感觉更明显
     * 2tick运行一次
     */
    private boolean motionDelay=false;
    /**
     * 水平速度
     */
    public int v_Horizon=0;
    /**
     * 竖直速度
     */
    public int v_Vertical=0;

    @Override
    public void render(Renderer r) {
        r.drawRect(x,y,width,height,false, Color.green);
        r.text("player  health:"+this.health,x,y);
    }

    @Override
    public void tick() {
        if (motionDelay){
            motionDelay=false;
            if (left) v_Horizon--;
            if (right) v_Horizon++;
            if (up) v_Vertical--;
            if (down) v_Vertical++;
            if (left|right){
                if (v_Horizon>SPEED_MAX) v_Horizon=SPEED_MAX;
                else if (v_Horizon<-SPEED_MAX) v_Horizon=-SPEED_MAX;
            }else {
                if (v_Horizon>0) v_Horizon--;
                else if (v_Horizon<0) v_Horizon++;
            }
            if (up|down){
                if (v_Vertical>SPEED_MAX) v_Vertical=SPEED_MAX;
                else if (v_Vertical<-SPEED_MAX) v_Vertical=-SPEED_MAX;
            }else {
                if (v_Vertical>0) v_Vertical--;
                else if (v_Vertical<0) v_Vertical++;
            }
        }else {
            motionDelay=true;
        }
        if (v_Horizon!=0){
            x+=v_Horizon;
            if (x<1) x=1;
            else if (x+width>Setting.WIDTH) x=Setting.WIDTH-width;
        }
        if (v_Vertical!=0){
            y+=v_Vertical;
            if (y<1) y=1;
            else if (y+height>Setting.HEIGHT) y=Setting.HEIGHT-height;
        }
        fire();
        if (health<=0){
            Game.gg();
            Game.removeObj(this);
        }
    }

    public void fire(){
        if (--fireDelay<1){
            fireDelay=FIRE_DELAY;
//            if (Game.money<10)  //如果金钱超过10则改为随机子弹
            if (STRONGER){
                Game.addObject(new PlayerBullet(x, y));
                Game.addObject(new PlayerBullet(rightX(), y));
            }else {
                Game.addObject(new PlayerBullet(MathHelper.toCenter(x,width,PlayerBullet.WIDTH_BULLET),y));
            }
//            else
//                Game.addObject(new PlayerBullet(MathHelper.rand(x, rightX()), y));  //  获得升级
        }
    }

    public Player(){
        super(Setting.PLAYER_HEALTH);
        this.width=40;
        this.height=40;
        this.x=(Setting.WIDTH-width)/2;
    }

    public void reset(){
        this.x=(Setting.WIDTH-width)/2;
        this.y= Setting.HEIGHT-150;
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
//            case KeyEvent.VK_SPACE:
//                fire=true;
//                break;
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
//            case KeyEvent.VK_SPACE:
//                fire=false;
//                break;
        }
    }
}
