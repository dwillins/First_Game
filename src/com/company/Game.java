package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 900, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;

    private final Handler handler;

    //game objects here
    static Player player = new Player(100, 100, ID.Player1);
    static Ball ball = new Ball(300, 300, ID.Ball);
    static Player2 player2 = new Player2(720, 100, ID.Player2);
    static AiPlayer aiPlayer = new AiPlayer(720, 100, ID.AiPlayer);

    public Game() {
        handler = new Handler();

        new Window(WIDTH, HEIGHT, "PONG", this, handler);

        handler.addObject(player);
        handler.addObject(ball);

        //select game mode here
        boolean multiplayer = false;

        if (multiplayer) {
            handler.addObject(player2);
        } else {
            handler.addObject(aiPlayer);
        }
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void tick() {
        handler.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0,0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public void run() {
        //primary game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000.0 / amountOfTicks;
        double delta = 0.0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now-lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }
}
