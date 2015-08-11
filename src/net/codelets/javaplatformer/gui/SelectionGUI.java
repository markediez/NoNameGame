package net.codelets.javaplatformer.gui;

import net.codelets.javaplatformer.GamePanel;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Mark on 8/11/2015.
 */
public class SelectionGUI {
    private int posX;
    private int posY;
    private int width;
    private int height;
    private String[] choices;

    public SelectionGUI(String[] choices, int width, int height) {
        this.posX = GamePanel.WIDTH / 2;
        this.posY = GamePanel.HEIGHT / 2;
        this.width = width;
        this.height = height;
        this.choices = choices;
    }

    public void update() {

    }

    public void draw(Graphics g) {

    }

    public void keyPressed(int key) {
        switch(key) {
            case KeyEvent.VK_UP:
                break;
            case KeyEvent.VK_DOWN:
                break;
            case KeyEvent.VK_ENTER:
                break;
        }
    }
}
