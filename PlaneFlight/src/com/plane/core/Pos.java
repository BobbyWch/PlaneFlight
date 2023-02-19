package com.plane.core;

import com.plane.core.obj.GameObject;

public class Pos {
    public int x;
    public int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pos() {
    }

    public boolean samePos(Pos pos) {
        return x == pos.x && y == pos.y;
    }

    /**
     * 这个点是否在某个GameObject内部
     */
    public boolean isIn(GameObject o){
        return x>o.x&&x<o.x+o.width&&x>o.y&&x<o.y+o.height;
    }
    @Override
    public String toString(){
        return "Pos x:"+x+"  y:"+y;
    }
}
