package com.plane;

import com.plane.core.Game;
import com.plane.ui.GameFrame;

public class Main {
    public static void main(String[] args) {
        Game.init();
        new GameFrame().setVisible(true);
    }
}
