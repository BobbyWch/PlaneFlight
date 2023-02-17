package com.plane.ui;

import com.plane.core.Game;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame(){
        super("飞机大战");
        setSize(1280, 720);
        setResizable(false);
        addKeyListener(Game.player);
        getContentPane().add(new GamePane(), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
