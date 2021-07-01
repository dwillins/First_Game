package com.company;

import java.awt.*;

public class Player2 extends GameObject{

    public Player2(int x, int y, ID id) {
        super(x, y, id);
    }

    // moves the player based on pressed key
    public void move(int key) {
        if (key == 38) {
            this.setVelY(-3);
        } else if (key == 40) {
            this.setVelY(3);
        }
    }

    // stops the player when a key is released
    public void stop(int key) {
        if (key == 38 || key == 40) {
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
