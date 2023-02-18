package com.plane.core.objs.bullets;

import com.plane.Setting;
import com.plane.core.Game;
import com.plane.core.objs.GameObject;

public abstract class Bullet extends GameObject {
    /**
     * 子弹是否由玩家发射
     */
    public boolean isMy;

    /**
     * 移除越界的子弹
     */
    @Override
    public void tick() {
        if (this.y+this.height<0) Game.removeObj(this);
        else if (this.y> Setting.HEIGHT) Game.removeObj(this);
    }
}
