package net.codelets.javaplatformer;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mark Diez on 8/3/2015.
 */
public class Game {
    public static void main(String[] args) {
        JFrame frame = new JFrame("No Name Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new GamePanel(), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}