package net.codelets.javaplatformer.gamestates;

import java.awt.*;
import java.util.Stack;

/**
 * Created by Mark Diez on 8/3/2015.
 */
public class GameStateManager {
    private Stack<GameState> gameStateStack;

    public GameStateManager() {
        gameStateStack = new Stack<GameState>();
        gameStateStack.push(new GameStateMenu(this));
    }

    public void push(GameState newState) {
        gameStateStack.push(newState);
    }

    public void update() {
        gameStateStack.peek().update();
    }

    public void draw(Graphics g) {
        gameStateStack.peek().draw(g);
    }

    public void keyPressed(int key) {
        gameStateStack.peek().keyPressed(key);
    }

    public void keyReleased(int key) {
        gameStateStack.peek().keyReleased(key);
    }
}
