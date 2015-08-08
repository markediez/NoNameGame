package net.codelets.javaplatformer.gamestates;

import java.awt.*;

/**
 * Created by Mark Diez on 8/3/2015.
 */
public abstract class GameState {

    protected GameStateManager gsm;
    public static double xOffset, yOffset;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
        this.init();
        this.xOffset = 0;
        this.yOffset = 0;
    }

    public abstract void init();
    public abstract void update();
    public abstract void draw(Graphics g);
    public abstract void keyPressed(int key);
    public abstract void keyReleased(int key);
}
