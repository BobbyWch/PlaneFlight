package com.plane.core.objs;

import com.plane.ui.Renderer;

public abstract class GameObject {
    public int x;
    public int y;
    public int width;
    public int height;
    public abstract void render(Renderer r);
    public boolean isCover(GameObject o){
        return bottomY()>=o.y&&y<=o.bottomY()&&rightX()>=o.x&&x<=o.rightX();
    }
    public abstract void tick();
    public int centreX() {
        return x + width / 2;
    }

    public int rightX() {
        return width + x;
    }

    public int bottomY() {
        return height + y;
    }
}
