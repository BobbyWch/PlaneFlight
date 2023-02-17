package com.plane.core;

public final class MathHelper {
    /**
     * 比如：player坐标(20,20)，长和宽都是50,我要发射一个子弹，宽度为5
     * 那么调用toCenter(20,50,5)即可获得子弹的x坐标
     * @param a 原始对象x或y坐标
     * @param b 原始对象长或宽
     * @param c 新对象长或宽
     * @return 坐标
     */
    public static int toCenter(int a,int b,int c){
        return a+(b-c)/2;
    }
}
