package com.plane.ui;

/**
 * 渲染线程，与主线程平行
 * 每秒绘制fps帧图像
 * 我没给注释的就不太重要了
 */
public final class RenderThread extends Thread{
    private int fps=60;
    private final GamePane pane;
    public RenderThread(GamePane pane){
        this.pane=pane;
    }

    /**
     * 设置帧数，因为游戏暂停时可以以更低的帧数绘制
     * @param fps 帧数
     */
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
