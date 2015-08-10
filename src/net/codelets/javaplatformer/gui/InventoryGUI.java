package net.codelets.javaplatformer.gui;

import net.codelets.javaplatformer.colors.PlatformColor;
import net.codelets.javaplatformer.entities.Player;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by byrus on 8/9/2015.
 */
public class InventoryGUI {
    private Player player;
    private boolean open;

    public InventoryGUI(Player player) {
        this.player = player;
        this.open = false;
    }

    public void update() {

    }

    public void draw(Graphics g) {
        if(open) {
            g.setColor(PlatformColor.LIGHT_BROWN);
            g.fillRect(100,100,100,100);
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
                System.out.println(open);
                break;
        }
    }
}
