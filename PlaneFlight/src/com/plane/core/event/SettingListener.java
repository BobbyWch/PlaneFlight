package com.plane.core.event;

import com.plane.ui.Preference;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Preference p = new Preference("设置");
        p.ready();
    }
}
