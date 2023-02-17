package com.plane.ui;

import java.awt.*;

public class Renderer {
    private Graphics g;
    public Renderer(){
    }

    public void setGraphic(Graphics g) {
        this.g = g;
    }

    /**
     *  绘制矩形
     */
    public void drawRect(int x,int y,int width,int height,boolean fill){
        if (fill) g.fillRect(x, y, width, height);
        else g.drawRect(x, y, width, height);
    }
    public void text(String s,int x,int y){
        g.drawString(s,x,y);
    }
}
