package net.codelets.javaplatformer;

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

    public GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.addKeyListener(this);
        this.setFocusable(true);
        this.isRunning = false;
        this.start();
    }

    public void start() {
        System.out.println("Went in start");
        gsm = new GameStateManager(new GameStateMenu(gsm));
        isRunning = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        long start, wait, elapsed;
        start = wait = elapsed = 0;
        while(isRunning) {
            start = System.nanoTime();
            this.update();
            this.repaint();
            elapsed = System.nanoTime() - start;

            // 1000/60 is the target 60 FPS ~ elapsed/1000000 converts elapsed time to milliseconds
            wait = 1000/60 - elapsed / 1000000;
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
