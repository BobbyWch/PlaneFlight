package com.plane.core.objs;

import com.plane.ui.Renderer;

public abstract class GameObject {
    public int x;
    public int y;
    public int width;
    public int height;
    public abstract void render(Renderer r);
    public boolean isCover(GameObject o){
        //TODO 判断两个是否相交
        return false;
    }
    public abstract void tick();
}
