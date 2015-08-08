package net.codelets.javaplatformer;

import net.codelets.javaplatformer.gamestates.GameStateManager;
import net.codelets.javaplatformer.gamestates.GameStateMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Mark Diez on 8/3/2015.
 */
public class GamePanel extends JPanel implements Runnable, KeyListener {
    // public
    public static final int WIDTH = 850;
    public static final int HEIGHT = 500;
    // private
    private boolean isRunning;
    private Thread gameThread;
    private GameStateManager gsm;
    private int FPS;
    private long targetTime;

    public GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.addKeyListener(this);
        this.setFocusable(true);
        this.isRunning = false;
        this.start();
    }

    public void start() {
        gsm = new GameStateManager();
        isRunning = true;
        FPS = 60;
        targetTime = 1000 / FPS;
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        long start, wait, elapsed;
        gsm.push(new GameStateMenu(gsm));
        while(isRunning) {
            start = System.nanoTime();
            this.update();
            this.repaint();
            elapsed = System.nanoTime() - start;

            // targetTime = sec / frames ~ elapsed/1000000 converts elapsed time to milliseconds
            wait = targetTime - elapsed / 1000000;
                if(wait <= 0) {
                wait = 5;
            }

            try {
                Thread.sleep(wait);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void update() {
        gsm.update();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        gsm.draw(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        gsm.keyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        gsm.keyReleased(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /*
        Getters and Setters
     */

}
