package com.plane.ui.button;

import com.plane.core.Game;
import com.plane.core.event.MoneyChangeEvent;
import com.plane.core.event.MoneyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 购买按钮父类
 */
public abstract class BuyButton extends JLabel implements MoneyListener, MouseListener {
    private static final Font font=new Font("微软雅黑",Font.BOLD,20);

    public int cost;
    private boolean enable=false;
    public int level=0;
    public BuyButton(String name,int cost){
        super(name);
        this.cost=cost;
        setFont(font);
        setForeground(Color.gray);
        setBorder(null);
        setFocusable(false);
        addMouseListener(this);
        MoneyChangeEvent.addListener(this);
    }

    @Override
    public void moneyChange(MoneyChangeEvent event) {
        if (!reachLimit()&&event.newValue>=cost){
            if (!enable){
                enable=true;
                setForeground(Color.black);
            }
        }else {
            if (enable){
                enable=false;
                setForeground(Color.gray);
            }
        }
    }

    /**
     * 购买后的效果
     */
    protected abstract void onBuy();

    /**
     * 是否打到升级上限
     */
    protected abstract boolean reachLimit();

    @Override
    public void mouseClicked(MouseEvent e) {
        if (enable&&Game.running){
            Game.addMoney(-cost);
            level++;
            cost+=5;
            onBuy();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
