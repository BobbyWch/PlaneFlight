package com.plane.core.obj;

import com.plane.core.Pos;
import com.plane.ui.Renderer;

public abstract class GameObject extends Pos {
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
