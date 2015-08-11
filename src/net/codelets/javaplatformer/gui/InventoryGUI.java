package net.codelets.javaplatformer.gui;

import net.codelets.javaplatformer.GamePanel;
import net.codelets.javaplatformer.colors.PlatformColor;
import net.codelets.javaplatformer.entities.Player;
import net.codelets.javaplatformer.items.Bag;
import net.codelets.javaplatformer.items.Item;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by byrus on 8/9/2015.
 */
public class InventoryGUI {
    private Player player;
    private Bag inventory;

    private boolean open;

    private int posX;
    private int posY;
    private int currIndex;

    public InventoryGUI(Player player) {
        this.player = player;
        this.inventory = new Bag();
        this.inventory = player.getInventory();
        this.open = false;
        this.posX = GamePanel.WIDTH;
        this.posY = 0;
        this.currIndex = 0;
    }

    public void update() {

    }

    public void draw(Graphics g) {
        if(open) {
            // Background
            g.setColor(Color.BLACK);
            g.fillRect(posX - 205, posY + 95, 210, 310);
            g.setColor(PlatformColor.DARK_BROWN);
            g.fillRect(posX - 200, posY + 100, 200, 300);

            // Foreground
            g.setColor(Color.BLACK);
            g.fillRect(posX - 190, posY + 105, 100, 25);
            g.fillRect(posX - 190, posY + 140, 200, 250);
            g.setColor(PlatformColor.LIGHT_BROWN);
            g.fillRect(posX - 189, posY + 106, 98, 23);
            g.fillRect(posX - 189, posY + 141, 200, 248);

            // Words
            g.setColor(Color.WHITE);
            g.drawString("Inventory", posX - 185, posY + 123);
            for(int i = 0; i < inventory.getMaxLoad(); i++) {
                Item currItem = inventory.get(i);
                if(currItem != null) {
                    if(i == currIndex) g.setColor(Color.YELLOW);
                    else g.setColor(Color.WHITE);
                    g.drawString(currItem.getName(), posX - 185, posY + 160 + i*20);
                }
            }
        }
    }

    public void keyPressed(int key) {
        switch(key) {
            case KeyEvent.VK_I:
                if(open) {
                    open = false;
                } else {
                    open = true;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(currIndex < inventory.getCurrentLoad()-1)
                    currIndex++;
                else
                    currIndex = 0;
                break;
            case KeyEvent.VK_UP:
                if(currIndex > 0)
                    currIndex--;
                else
                    currIndex = inventory.getCurrentLoad()-1;
                break;
            case KeyEvent.VK_ENTER:
                player.use(inventory.get(currIndex));
                inventory.remove(currIndex);
                break;
        }
    }
}
