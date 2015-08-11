package net.codelets.javaplatformer.gui;

import net.codelets.javaplatformer.entities.Player;

import java.awt.*;

/**
 * Created by byrus on 8/9/2015.
 */
public class StatusGUI {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 120;
    public static final int PORTRAIT_SIZE = 96;

    private Player player;
    private int posX;
    private int posY;
    private int maxHealth;
    private int currHealth;
    private double healthScale;

    public StatusGUI(Player player) {
        this.player = player;
        this.posX = 0;
        this.posY = 0;
        this.healthScale = 1;
        this.maxHealth = player.getHealth();
        this.currHealth = maxHealth;
    }

    public void update() {
        this.currHealth = player.getHealth();
        this.healthScale = currHealth / (double)maxHealth;
    }

    public void draw(Graphics g) {
        // Stroke Health
        g.setColor(Color.BLACK);
        g.fillRoundRect(posX + 12, posY + 17, 166, 26, 10, 10);
        // Health Display
        g.setColor(Color.WHITE);
        g.fillRoundRect(posX + 15, posY + 20, 160, 20, 10, 10);
        g.setColor(Color.RED);
        g.fillRoundRect(posX + 15, posY + 20, (int)(160 * healthScale), 20, 10, 10);

    }

    // Getters and Setters
    public void setPosX(int posX) { this.posX = posX; }
    public void setPosY(int posY) { this.posY = posY; }
}
