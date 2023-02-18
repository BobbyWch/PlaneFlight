package com.plane.ui;

import com.plane.Setting;
import com.plane.core.objs.Player;
import com.plane.core.objs.bullets.PlayerBullet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public final class GameBar extends JPanel {
    public GameBar(){
        super(new GridLayout(1,8,20,10));
        setSize(Setting.WIDTH,30);
        //只是测试
        JLabel upgrade=new JLabel("升级武器");
        add(upgrade);
        setBackground(Color.cyan);
        setForeground(Color.cyan);
        upgrade.setFocusable(false);
        upgrade.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton()==MouseEvent.BUTTON1){
                    PlayerBullet.DAMAGE+=10;
                }
            }
        });
//        upgrade.setBackground(new Color(0,0,0,0));
    }
}
