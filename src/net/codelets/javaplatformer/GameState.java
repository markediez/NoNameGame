package net.codelets.javaplatformer;

import java.awt.*;

/**
 * Created by Mark Diez on 8/3/2015.
 */
public abstract class GameState {

    private GameStateManager gsm;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
        this.init();
    }

    public abstract void init();
    public abstract void update();
    public abstract void draw(Graphics g);
    public abstract void keyPressed(int key);
    public abstract void keyReleased(int key);
}
