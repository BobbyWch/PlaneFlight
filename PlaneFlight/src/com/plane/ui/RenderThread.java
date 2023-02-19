package com.plane.ui;

import static java.lang.System.currentTimeMillis;

/**
 * 渲染线程，与主线程平行
 * 每秒绘制fps帧图像
 * 我没给注释的就不太重要了
 */
public final class RenderThread extends Thread{
    public static RenderThread instance;
    private int fps=60;
    private int delay;
    private final GamePane pane;
    public RenderThread(GamePane pane){
        this.pane=pane;
        delay=1000/fps;
        instance=this;
    }

    /**
     * 设置帧数，因为游戏暂停时可以以更低的帧数绘制
     * @param fps 帧数
     */
    public void setFps(int fps) {
        this.fps = fps;
        delay=1000/fps;
    }

    @Override
    public void run() {
        long t1,t2;
        try {
            while (true){
                t1=currentTimeMillis();
                pane.repaint();
                //假设电脑太拉了，fps刷不满，检查一下
                t2=currentTimeMillis()-t1;
                if (t2<delay) Thread.sleep(delay-t2);
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
