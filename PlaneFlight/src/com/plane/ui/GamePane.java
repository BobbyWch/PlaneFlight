package com.plane.ui;

import com.plane.core.Game;
import com.plane.core.GameObject;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;

public class GamePane extends JPanel {
    //全局实例
    public static GamePane instance;
    private final LinkedList<GameObject> allObjects=new LinkedList<>();
    private final Renderer renderer=new Renderer();
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
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
        addKeyListener(Game.player);
        Game.player.x=600;
        Game.player.y=500;
        new Thread(() -> {
            try {
                while (true){
                    Thread.sleep(15);
                    repaint();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
    }
}
