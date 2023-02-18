package com.plane.core.move;

import com.plane.core.objs.GameObject;
import com.sun.istack.internal.NotNull;

import javax.swing.*;

/**
 * 高级移动
 */
/*----------算法警告----------*/
public final class MoveControl {
    /**
     * 倾角，移动时y轴移动speed格，x轴移动speed*rotate格
     * 正数说明向右下移动，负数左下（speed为正数时，反之亦然）
     */
    public double rotate=0;
    /**
     * 更精确的坐标
     */
    public float x;
    public float y;
    /**
     * 速度，正的向下，负的向上
     */
    public float speed;
    /**
     * 控制的游戏对象
     */
    private final GameObject obj;

    /**
     *
     * @param o 对象
     * @param speed 速度
     * @param direction MoveControl.UP或MoveControl.DOWN
     */
    public MoveControl(GameObject o, int speed, int direction){
        this.obj=o;
        this.speed=speed*direction;
        this.x=o.x;
        this.y=o.y;
    }

    /**
     * 在原有路线上移动
     */
    public void move(){
        obj.x=(int) (this.x+=this.speed*this.rotate);
        obj.y=(int) (this.y+=this.speed);
    }

    /**
     * 根据target的位置计算rotate
     */
    public void update(GameObject target){
        rotate=(((double)target.x)- obj.x)/(target.y-obj.y);
        //限制一下，不然会飞
        if (rotate>1.5){
            rotate=1.5;
        }else if (rotate<-1.5){
            rotate=-1.5;
        }
    }
    /**
     * 设置方向，上或下
     */
    public void setDirection(int direction){
        //如果异号，说明方向反了
        if (speed*direction<0){
            //改变方向
            speed*=-1;
        }
    }


    /**
     * 全局常量
     */
    public static final int UP=-1;
    public static final int DOWN=1;
}
