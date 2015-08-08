package net.codelets.javaplatformer.gamestates;

import net.codelets.javaplatformer.GamePanel;
import net.codelets.javaplatformer.entities.Player;
import net.codelets.javaplatformer.objects.Block;

import java.awt.*;

/**
 * Created by Mark Diez on 8/4/2015.
 */
public class GameStateLevelZero extends GameState {
    // Properties
    Player player;
    Block[] blocks;
    // Constructor
    public GameStateLevelZero(GameStateManager gsm) {
        super(gsm);
    }

    // Methods
    @Override
    public void init() {
        blocks = new Block[14];
        player = new Player(GamePanel.WIDTH/2, GamePanel.HEIGHT - 150);

        for (int i = 0; i < blocks.length; i++) {
            blocks[i] = new Block(GamePanel.WIDTH/4 + i*(Block.BLOCK_SIZE + 1), GamePanel.HEIGHT - 100 + Block.BLOCK_SIZE*i ) ;
        }
    }

    @Override
    public void update(){
        player.update(blocks);
        for(int i = 0; i < blocks.length; i++) {
            blocks[i].update(blocks);
        }
    }

    @Override
    public void draw(Graphics g) {
        player.draw(g);
        for (int i = 0; i < blocks.length; i++) {
            blocks[i].draw(g);
        }
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
