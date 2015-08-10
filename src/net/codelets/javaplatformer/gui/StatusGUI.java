package net.codelets.javaplatformer.gui;

import net.codelets.javaplatformer.colors.PlatformColor;
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
        // Stroke Background
        g.setColor(Color.black);
        g.fillRect(posX, posY, WIDTH, HEIGHT);
        // Background
        g.setColor(PlatformColor.DARK_BROWN);
        g.fillRect(posX, posY + 3, 297, 114);
        // Stroke Portrait
        g.setColor(Color.BLACK);
        g.fillRoundRect(posX + 10, posY + 10, PORTRAIT_SIZE + 4, PORTRAIT_SIZE + 4,10,10);
        // Actual Portrait
        g.setColor(PlatformColor.LIGHT_BROWN);
        g.fillRoundRect(posX + 12, posY + 12, PORTRAIT_SIZE, PORTRAIT_SIZE,10,10);

        // Stroke Health
        g.setColor(Color.BLACK);
        g.fillRoundRect(posX + 122, posY + 17, 166, 26, 10, 10);
        // Health Display
        g.setColor(Color.WHITE);
        g.fillRoundRect(posX + 125, posY + 20, 160, 20, 10, 10);
        g.setColor(Color.RED);
        g.fillRoundRect(posX + 125, posY + 20, (int)(160 * healthScale), 20, 10, 10);

    }

    // Getters and Setters
    public void setPosX(int posX) { this.posX = posX; }
    public void setPosY(int posY) { this.posY = posY; }
}
