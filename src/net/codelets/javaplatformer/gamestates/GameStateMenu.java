package net.codelets.javaplatformer.gamestates;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Mark Diez on 8/3/2015.
 */
public class GameStateMenu extends GameState {
    private BufferedImage bg;
    private String[] options;
    private int currentSelection;
    public GameStateMenu(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        currentSelection = 0;
        options =  new String[3];
        options[0] = "Start";
        options[1] = "Options";
        options[2] = "Quit";
        try {
            bg = ImageIO.read(new File("res/bg_menu.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(){

    }

    @Override
    public void draw(Graphics g) {
        // Background
        g.drawImage(bg, 0, 0, null);
        g.setColor(new Color(0, 0, 0, 75));
        g.fillRoundRect(325, 325, 175, 100, 48, 48);
        g.setColor(Color.WHITE);
        // Items
        g.setFont(new Font("Courier New", Font.BOLD, 16));
        for(int i = 0; i < options.length; i ++) {
            int x = 365;
            int y = 360 + 20*i;
            if(i == currentSelection) {
                g.setColor(Color.RED);
                g.fillRect(x-10, y-7, 5, 5);
                g.setColor(Color.YELLOW);
            } else {
                g.setColor(Color.WHITE);
            }
            g.drawString(options[i], x, y);
        }
    }

    @Override
    public void keyPressed(int key) {
        switch (key) {
            case KeyEvent.VK_DOWN:
                if(currentSelection < 2) currentSelection++;
                else currentSelection = 0;
                break;
            case KeyEvent.VK_UP:
                if(currentSelection > 0) currentSelection--;
                else currentSelection = 2;
                break;
            case KeyEvent.VK_ENTER:
                run(currentSelection);
                break;
        }
    }

    private void run(int selection) {
        switch(selection) {
            case 0:     // START
                gsm.push(new GameStateLevelZero(gsm));
                break;
            case 1:     // OPTIONS
                break;
            case 2:     // QUIT
                System.exit(0);
                break;
        }
    }
    @Override
    public void keyReleased(int key) {

    }
}
