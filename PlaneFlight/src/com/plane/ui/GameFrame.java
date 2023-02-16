package com.plane.ui;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame(){
        super("飞机大战");
        setSize(1280, 720);
        setResizable(false);
        getContentPane().add(new GamePane(), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
