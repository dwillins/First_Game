package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/*
* w: 87
* A: 65
* S: 83
* D: 68
* up arrow: 38
* down arrow: 40
* */
public class KeyInput extends KeyAdapter {


    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        Game.player.move(key);
        Game.player2.move(key);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        Game.player.stop(key);
        Game.player2.stop(key);
    }
}
