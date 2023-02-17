package com.plane.ui;

import com.plane.core.Game;
import com.plane.core.objs.GameObject;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class GamePane extends JPanel {
    //全局实例
    public static GamePane instance;
    private final LinkedList<GameObject> allObjects=new LinkedList<>();
    private final Renderer renderer=new Renderer();
    @Override
    public void paint(Graphics g) {
        g.clearRect(0,0,getWidth(),getHeight());//直接清除矩形，不调用父类
        Renderer r=renderer;//创建局部变量，提速
        r.setGraphic(g);
        for (GameObject o:allObjects){
            o.render(r);
            o.tick();
        }
    }
    public void addObject(GameObject o){
        allObjects.add(o);
    }
    public GamePane(){
        instance=this;
        setLayout(null);
        addObject(Game.player);
        Game.player.x=600;
        Game.player.y=500;
        new RenderThread(this).start();
    }
}
