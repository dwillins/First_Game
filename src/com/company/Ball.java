package com.company;

import java.awt.*;

public class Ball extends GameObject{

    public Ball(int x, int y, ID id) {
        super(x, y, id);

        // starting velocity
        velX = 3;
        velY = 3;
    }

    @Override
    public void tick() {
        if (x > 865) {
            Game.player1Score();
            x = 420;
            y = 360;
        } else if (x < 0) {
            Game.player2Score();
            x = 420;
            y = 360;
        }
        if (y > 615 || y < 0) {
            // bounces off the horizontal frames
            velY *= -1;
        }
        if ((Game.player.y + 200 > y && y > Game.player.y) && (Game.player.x + 50 > x && x > Game.player.x)) {
            velX *= -1;
        }
        if ((Game.player2.y + 200 > y && y > Game.player2.y) && (Game.player2.x > x && x > Game.player2.x - 20)) {
            velX *= -1;
        }
        if ((Game.aiPlayer.y + 200 > y && y > Game.aiPlayer.y) && (Game.aiPlayer.x > x && x > Game.aiPlayer.x - 25)) {
            velX *= -1;
        }
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 20, 20);
    }
}
