package com.plane.ui;

import com.plane.core.obj.Player;

import javax.swing.*;
import java.awt.*;

public class PreferencePane extends JPanel {
    public static JLabel mode1;   //操作模式
    public static JLabel mode2;
    public static JLabel space;
    public static JLabel picture;
    public static JCheckBox check1;
    public static JCheckBox check2;
    public PreferencePane(){
        super();
        setLayout(new FlowLayout());
        setBackground(Color.GRAY);
        setVisible(true);
        ready();
    }

    public void init(){
        mode1=new JLabel("键盘方向键操作");
        mode2=new JLabel("WASD操作");
        space=new JLabel("       ");
        check1=new JCheckBox();
        check2=new JCheckBox();
    }

    public void ready(){
        init();
        add(mode1);
        add(check1);
        add(space);
        add(mode2);
        add(check2);

        check1.setSelected(true);
        if (check2.isSelected()) {   //选择操作模式
            Player.WASD=true;
            if (check1.isSelected()){
                check1.setSelected(false);
                repaint();
                Player.WASD=true;
            }
        }else {
            Player.WASD=false;
        }
    }
}
