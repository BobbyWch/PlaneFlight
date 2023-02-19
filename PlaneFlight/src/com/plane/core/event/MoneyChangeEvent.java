package com.plane.core.event;

import java.util.ArrayList;

public final class MoneyChangeEvent extends Event{
    public final int oldValue;
    public final int newValue;

    public MoneyChangeEvent(int oldValue, int newValue) {
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    private static final ArrayList<MoneyListener> listeners=new ArrayList<>();
    public static void post(MoneyChangeEvent event){
        for (MoneyListener l:listeners){
            l.moneyChange(event);
        }
    }
    public static void addListener(MoneyListener l){
        listeners.add(l);
    }
    public static void removeListener(MoneyListener l){
        listeners.remove(l);
    }
}
