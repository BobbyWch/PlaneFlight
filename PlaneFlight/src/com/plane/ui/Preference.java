package com.plane.ui;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏偏好设置
 */

public class Preference extends JFrame {
    public Preference(String name){
        super(name);
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void ready(){
        getContentPane().add(new PreferencePane(), BorderLayout.CENTER);
    }
}
