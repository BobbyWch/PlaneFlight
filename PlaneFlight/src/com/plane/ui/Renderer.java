package com.plane.ui;

import com.plane.core.obj.LivingObject;

import java.awt.*;

public final class Renderer {
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
    /**
     * 画血条，自动调整
     * @param l 有血量的对象
     */
    public void healthBar(LivingObject l){
        healthBar(l,l.x+5,l.y-10,l.width-10,6);
    }
    /**
     * 画血条
     * @param l 有血量的对象
     * @param x 坐标
     * @param y 坐标
     * @param width 宽度
     * @param height 高度
     */
    public void healthBar(LivingObject l,int x,int y,int width,int height){
        //能用就行，不想写注释了
        drawRect(x,y,width,height,true,Color.red);
        if (l.health==l.healthMax) return;
        int a=(int) (((double)l.health)/l.healthMax*width);
        if (a<0) a=0;
        drawRect(a+x,y+1, width-a-1,height-2,true,Color.white);
    }

    /**
     * 化缘
     */
    public void drawCycle(int x,int y,int width,int height,Color color){
        g.setColor(color);
        g.fillRoundRect(x,y,width,height,width/2,height/2);
    }
}
