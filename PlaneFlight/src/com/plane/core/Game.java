package com.plane.core;

/**
 * 存放全局单例
 */
public class Game {
    public static Player player;
    public static void init(){
        player=new Player();
    }
}
