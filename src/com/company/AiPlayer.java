package com.company;

import java.awt.*;

public class AiPlayer extends GameObject{
    public AiPlayer(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {
        if (y > 535 || y < 0) {
            velY = 0;
        }
        x += velX;
        y = Game.ball.y - 100;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 50, 200);
    }
}
