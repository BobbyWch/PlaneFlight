package com.plane;

import com.plane.core.Game;
import com.plane.ui.GameFrame;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Game.init();
        new GameFrame().setVisible(true);
    }
}
