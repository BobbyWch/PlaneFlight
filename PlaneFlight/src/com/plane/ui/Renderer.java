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
    public void drawRect(int x,int y,int width,int height,boolean fill,Color color){
        g.setColor(color);
        if (fill) g.fillRect(x, y, width, height);
        else g.drawRect(x, y, width, height);
    }
    public void text(String s,int x,int y){
        g.drawString(s,x,y);
    }
    public void text(String s,int x,int y,Color color){
        g.setColor(color);
        g.drawString(s,x,y);
    }
    public void drawImage(Image img,int x,int y){
        if (img==null) return;
        g.drawImage(img,x,y,null);
    }
}
