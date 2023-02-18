package com.plane.core;

/**
 * 间隔运行，比如每40fps运行一次
 * 适用于计算量较大的情况，或者特殊需要，比如Soldier定位player
 */
public interface LazyRun {
    void lazyRun();
}
