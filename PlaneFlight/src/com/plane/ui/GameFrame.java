package com.plane.ui;

import com.plane.Setting;
import com.plane.core.Game;
import com.plane.core.event.SettingListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public final class GameFrame extends JFrame implements WindowListener {
    public static JMenu preference;
    public static JMenuItem game;
    public static JMenuBar bar;
    public GameFrame() {
        super("飞机大战");
        setSize(Setting.WIDTH, Setting.HEIGHT);
        setResizable(false);
        preference=new JMenu("Preferences");
        bar=new JMenuBar();
        game=new JMenuItem("设置");
        preference.add(game);
        bar.add(preference);
        game.addActionListener(new SettingListener());

        addKeyListener(Game.player);
        getContentPane().add(bar, BorderLayout.NORTH);
        getContentPane().add(new GamePane(), BorderLayout.CENTER);
        setJMenuBar(bar);
        addWindowListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        Setting.WIDTH = GamePane.instance.getWidth();
        Setting.HEIGHT = GamePane.instance.getHeight();
        Game.start();
    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}