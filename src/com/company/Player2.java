package com.company;

import java.awt.*;

public class Player2 extends GameObject{

    public Player2(int x, int y, ID id) {
        super(x, y, id);
//        velX = 3;
//        velY = 3;
    }

    public void move(int key) {
        if (key == 38) {
            velY = -3;
        } else if (key == 40) {
            velY = 3;
        }
//        if (key == 65) {
//            velX = -3;
//        } else if (key == 68) {
//            velX = 3;
//        }
    }

    public void stop(int key) {
        if (key == 38 || key == 40) {
            velY = 0;
        }
//        if (key == 65 || key == 68) {
//            velX = 0;
//        }
    }

    @Override
    public void tick() {
        if (x > 785 || x < 0) {
            velX *= -1;
        }
        if (y > 535 || y < 0) {
            velY *= -1;
        }
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 100, 100);
    }
}
