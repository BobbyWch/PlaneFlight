package com.plane.core;

import com.plane.core.objs.GameObject;
import com.plane.core.objs.Player;
import com.plane.core.objs.enemy.Enemy;
import com.plane.core.objs.enemy.Soldier;
import com.plane.core.objs.enemy.Tank;
import com.plane.ui.RenderThread;

import java.util.LinkedList;

/**
 * 存放全局单例
 */
public final class Game {
    /**
     * 所有注册的游戏对象
     */
    public static final LinkedList<GameObject> allObjects = new LinkedList<>();
    public static final LinkedList<Enemy> enemies = new LinkedList<>();
    /**
     * 添加、删除游戏对象的缓存
     * 这里说明一下为什么不直接操作：因为java foreach遍历集合类时如果在循环里添加，删除元素，会报错
     * 使用缓存后，当前tick内的操作会在下一tick渲染
     */
    public static final LinkedList<GameObject> waitRmv = new LinkedList<>();
    public static final LinkedList<GameObject> waitAdd = new LinkedList<>();
    public static Player player;
    public static int round = 0;
    public static int money = 0;
    /**
     * 游戏是否正在运行
     */
    public static boolean running = false;

    /**
     * 初始化，软件第一次启动时启动
     */
    public static void init() {
        player = new Player();
    }

    /**
     * 开始一局新的游戏
     */
    public static void start() {
        running = true;
        money = 0;
        timer = 0;
        RenderThread.instance.setFps(60);
        nextRound();
    }

    /**
     * 游戏结束
     */
    public static void gg() {
        running = false;
        RenderThread.instance.setFps(10);
        System.out.println("Game Over");
    }

    /**
     * 添加游戏对象
     */
    public static void addObject(GameObject o) {
//        System.out.println("add");
        waitAdd.add(o);
    }

    /**
     * 移除游戏对象
     */
    public static void removeObj(GameObject o) {
//        System.out.println("remove");
        waitRmv.add(o);
    }

    public static int timer = 0;

    public static void tick() {
        if (++timer == 40) {
            for (GameObject o : allObjects) {
                if (o instanceof LazyRun) {
                    ((LazyRun) o).lazyRun();
                }
            }
            timer = 0;
        }
        if (waitRmv.size() > 0) {
            for (GameObject o : Game.waitRmv) {
                allObjects.remove(o);
                if (o instanceof Enemy) {
                    Game.enemies.remove(o);
                }
            }
            waitRmv.clear();
        }
        if (waitAdd.size() > 0) {
            for (GameObject o : Game.waitAdd) {
                allObjects.add(o);
                if (o instanceof Enemy) {
                    Game.enemies.add(((Enemy) o));
                }
            }
            waitAdd.clear();
        }
        if (enemies.size() == 0) {
            nextRound();
        }
    }

    public static void nextRound() {
        round++;
        spawnEnemy();
    }

    public static void spawnEnemy() {
        for (int i = 0; i < round; i++) {
            Game.addObject(new Soldier(Soldier.HEALTH, 100 + i * 100, 0));  //添加小兵
        }
        //测试用
        Game.addObject(new Tank(Tank.HEALTH, 900, 0));
//        if (round > 2) {
//            Game.addObject(new Tank(Tank.HEALTH, 900, 0));  //添加坦克
//        }
    }
}