package com.plane.ui;

import com.plane.core.Game;

import javax.swing.*;

public class RenderThread extends Thread{
    private int fps=60;
    private final GamePane pane;
    public RenderThread(GamePane pane){
        this.pane=pane;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    @Override
    public void run() {
        try {
            while (true){
                Thread.sleep(1000/fps);
                pane.repaint();
            }
        }catch (InterruptedException inter){
            System.out.println("Render Thread is Interrupted");
        }
    }
    @Override
    public void start(){
        System.out.println("Render Thread Start");
        super.start();
    }
}
