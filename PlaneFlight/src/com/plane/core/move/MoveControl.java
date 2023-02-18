package com.plane.core.move;

import com.plane.Setting;
import com.plane.core.MathHelper;
import com.plane.core.Pos;
import com.plane.core.objs.GameObject;
/**
 * 高级移动
 * 使用于所有会自己动的GameObject
 * 这里的方法如果有问题，我会注解@Deprecated
 * 其他的都是测试过的，看注释用就行了
 */
/*----------算法警告----------*/
public final class MoveControl {
    /**
     * 倾角，移动时y轴移动speed格，x轴移动speed*rotate格
     * 正数说明向右下移动，负数左下（speed为正数时，反之亦然）
     */
    public float rotate=0;
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
     * 待命位置
     */
    private int standY=-1;
    /**
     *
     * @param o 对象
     * @param speed 速度
     * @param direction MoveControl.UP或MoveControl.DOWN
     */
    public MoveControl(GameObject o, float speed, int direction){
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
     * 转速快，适用于追踪子弹
     */
    public void update(Pos target){
        rotate=(((float)target.x)- obj.x)/(target.y-obj.y);
        //限制一下，不然会飞
        if (rotate>1.5){
            rotate= 1.5F;
        }else if (rotate<-1.5){
            rotate= -1.5F;
        }
    }
    /**
     * 向target转向，一次转一点
     * 与update相比更加平滑
     * 适用于敌机转向
     */
    public void turn(Pos target){
        float r=(((float)target.x)- obj.x)/(target.y-obj.y);
        //这里考虑左右是否相同
        if (rotate>0){
            if (r>rotate){
                rotate*=1.4;
            }else if (r>0){
                rotate*=0.7;
            }else {
                if (rotate>0.2) rotate*=0.5;
                else rotate=-0.2f;
            }
        }else {
            if (r<rotate){
                rotate*=1.4;
            }else if (r<0){
                rotate*=0.7;
            }else {
                if (rotate<-0.2) rotate*=0.5;
                else rotate=0.2f;
            }
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
     * 走一段后待命
     */
    public void standBy(){
        if (standY==-1){
            standY=MathHelper.rand(130,(Setting.HEIGHT-obj.y)/3);
            rotate=0;
        }
        if (standY>obj.y) move();
    }

    /**
     * 全局常量
     */
    public static final int UP=-1;
    public static final int DOWN=1;
}
