package com.plane.core.weapon;

import com.plane.core.obj.LivingObject;

/**
 * 未来将使用Weapon取代Bullet，enemy和player都只使用Weapon
 * Weapon内部使用Bullet
 */
public abstract class Weapon {
    /**
     * 向目标发起攻击
     */
    public abstract void fire(LivingObject target);
}
