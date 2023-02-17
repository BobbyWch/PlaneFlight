package com.plane.ui;

import com.plane.Setting;
import com.plane.core.Game;
import com.plane.core.objs.GameObject;
import com.plane.core.objs.enemy.Enemy;
import com.plane.io.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class GamePane extends JPanel {
    //全局实例
    public static GamePane instance;
    private Image background;

    private final Renderer renderer=new Renderer();
    private final Font font=new Font("微软雅黑",Font.BOLD,27);
    private int fontHeight=0;
    /**
     * 绘图函数，绘制每一fps时调用
     */
    @Override
    public void paint(Graphics g) {
        g.setFont(font);
        if (fontHeight==0) fontHeight=g.getFontMetrics(font).getHeight();
        //直接清除矩形，不调用父类
        g.clearRect(0,0,getWidth(),getHeight());
        //创建局部变量，提速
        LinkedList<GameObject> all= Game.allObjects;
        Renderer r=renderer;
        //初始化渲染器
        r.setGraphic(g);
        r.drawImage(background,0,0);
        gui(r);
        //目前这里所有的循环都使用java自带的foreach遍历
        //后期如果要优化性能的话，可以手动实现
        for (GameObject o:all){
            o.render(r);
            o.tick();
        }
        Game.tick();
    }

    public GamePane(){
        instance=this;
        background= ImageLoader.getImage("res/background/day.jpeg",Setting.WIDTH,Setting.HEIGHT);
        setBounds(0,0, Setting.WIDTH,Setting.HEIGHT);
        setLayout(null);
        Game.addObject(Game.player);
        Game.player.x=(Setting.WIDTH-Game.player.width)/2;
        Game.player.y=Setting.HEIGHT-Game.player.height-50;
        new RenderThread(this).start();
    }
    private void gui(Renderer r){
        r.text(String.valueOf(Game.money),0,fontHeight,Color.orange);
    }
}
