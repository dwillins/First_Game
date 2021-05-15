package com.company;

import java.awt.*;

public class Player extends GameObject {

    public Player(int x, int y, ID id) {
        super(x, y, id);

        velX = 1;
    }

    @Override
    public void tick() {
//        if (x > 800) {
//            velX = -1;
//        } else if (x < 100){
//            velX = 1;
//        }
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 100, 100);
    }
}
