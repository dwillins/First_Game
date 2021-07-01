package com.company;

import java.awt.*;

public class AiPlayer extends GameObject{
    public AiPlayer(int x, int y, ID id) {
        super(x, y, id);
    }

    // follows the ball
    @Override
    public void tick() {
        this.setY(Game.ball.getY() - 100);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(this.getX(), this.getY(), 50, 200);
    }
}
