package com.plane.core;

import com.plane.core.objs.Player;

/**
 * 存放全局单例
 */
public class Game {
    public static Player player;
    public static void init(){
        player=new Player();
    }
}
