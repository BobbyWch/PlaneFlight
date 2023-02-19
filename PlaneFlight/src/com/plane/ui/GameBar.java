package com.plane.ui;

import com.plane.core.obj.Player;
import com.plane.core.obj.bullets.PlayerBullet;
import com.plane.ui.button.BuyButton;

import javax.swing.*;
import java.awt.*;

public final class GameBar extends JPanel {
    public GameBar(){
        super(new GridLayout(1,8,20,10));
        //只是测试
        add(new BuyButton("伤害提升",20) {
            @Override
            protected void onBuy() {
                PlayerBullet.DAMAGE+=10;
            }

            @Override
            protected boolean reachLimit() {
                return false;
            }
        });
        add(new BuyButton("攻速提升",20) {
            @Override
            protected void onBuy() {
                Player.FIRE_DELAY--;
            }

            @Override
            protected boolean reachLimit() {
                return false;
            }
        });
        setBorder(null);
        setBackground(Color.cyan);
        setForeground(Color.cyan);
    }
}
