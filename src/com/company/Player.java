package com.company;

import java.awt.*;

public class Player extends GameObject {

    public Player(int x, int y, ID id) {
        super(x, y, id);
    }

    // moves the player based on pressed key
    public void move(int key) {
        if (key == 87) {
            this.setVelY(-3);
        } else if (key == 83) {
            this.setVelY(3);
        }
    }

    // stops the player then key is released
    public void stop(int key) {
        if (key == 87 || key == 83) {
            this.setVelY(0);
        }
    }

    @Override
    public void tick() {
        x += this.getVelX();
        y += this.getVelY();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(this.getX(), this.getY(), 50, 200);
    }
}
