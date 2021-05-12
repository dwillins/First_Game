package com.company;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 900, HEIGHT = WIDTH / 12 * 9;

    public Game() {
        new Window(WIDTH, HEIGHT, "LETS BUILD A GAME", this);
    }

    public synchronized void start() {

    }

    public void run() {

    }
}
