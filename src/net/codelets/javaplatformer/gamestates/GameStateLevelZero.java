package net.codelets.javaplatformer.gamestates;

import net.codelets.javaplatformer.GamePanel;
import net.codelets.javaplatformer.entities.Player;
import net.codelets.javaplatformer.mapping.Map;
import net.codelets.javaplatformer.objects.Block;

import java.awt.*;

/**
 * Created by Mark Diez on 8/4/2015.
 */
public class GameStateLevelZero extends GameState {
    // Properties
    private Player player;
    private Block[][] blocks;
    private Map map;
    // Constructor
    public GameStateLevelZero(GameStateManager gsm) {
        super(gsm);
    }

    // Methods
    @Override
    public void init() {
        map = new Map("res/level0.map");
        blocks = map.getBlocks();
        player = new Player(GamePanel.WIDTH/2, GamePanel.HEIGHT - 150);
    }

    @Override
    public void update(){
        player.update(blocks);
        map.update();
    }

    @Override
    public void draw(Graphics g) {
        map.draw(g);
        player.draw(g);
    }

    @Override
    public void keyPressed(int key) {
        player.keyPressed(key);
    }

    @Override
    public void keyReleased(int key) {
        player.keyReleased(key);
    }
}
