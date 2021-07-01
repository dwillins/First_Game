package com.company;

import java.awt.*;
import java.util.Random;

public class Ball extends GameObject{

    public Ball(int x, int y, ID id) {
        super(x, y, id);
        // starting velocity
        this.setVelX(3);
        this.setVelY(3);
    }

    @Override
    public void tick() {
        // increments score when the ball touches the vertical frames
        if (this.getX() > 865) {
            Game.player1Score();
            reset();
        } else if (this.getX() < 0) {
            Game.player2Score();
            reset();
        }

        // bounces off the horizontal frames
        if (y > 615 || y < 0) {
            velY *= -1;
        }

        // makes the ball bounce off players
        if ((Game.player.getY() + 200 > this.getY() && this.getY() > Game.player.getY()) && (Game.player.getX() + 50 > this.getX() && this.getX() > Game.player.getX())) {
            velX *= -1;
        }
        if ((Game.player2.getY() + 200 > this.getY() && this.getY() > Game.player2.getY()) && (Game.player2.getX() > this.getX() && this.getX() > Game.player2.getX() - 4)) {
            velX *= -1;
        }
        if ((Game.aiPlayer.getY() + 200 > this.getY() && this.getY() > Game.aiPlayer.getY()) && (Game.aiPlayer.getX() > this.getX() && this.getX() > Game.aiPlayer.getX() - 20)) {
            velX *= -1;
        }

        x += this.getVelX();
        y += this.getVelY();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(this.getX(), this.getY(), 20, 20);
    }

    //resets the ball to a random position within a certain range
    public void reset() {
        Random random = new Random();
        int rand;
        do {
            rand = random.nextInt(60);
        } while (rand == 0);
        this.setX(360 + rand);
        this.setY(300 + rand);
    }
}
