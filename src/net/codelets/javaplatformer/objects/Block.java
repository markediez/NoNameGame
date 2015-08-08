package net.codelets.javaplatformer.objects;

import net.codelets.javaplatformer.entities.Entity;
import net.codelets.javaplatformer.gamestates.GameState;

import java.awt.*;

/**
 * Created by Mark Diez on 8/5/2015.
 */
public class Block extends Entity {
    // Properties
    public static final int BLOCK_SIZE = 32;
    // Constructors
    private Rectangle collisionBox;
    public Block(int posX, int posY) {
        super(posX, posY);
        collisionBox = new Rectangle(posX, posY, BLOCK_SIZE, BLOCK_SIZE);
    }

    // Methods
    @Override
    public void init() {

    }

    @Override
    public void update(Block[] blocks) {
        this.collisionBox.setLocation((int) posX - (int) GameState.xOffset, (int) posY - (int) GameState.yOffset);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect((int)posX - (int)GameState.xOffset, (int)posY - (int)GameState.yOffset, BLOCK_SIZE, BLOCK_SIZE);
    }


    public Rectangle getCollisionBox() { return this.collisionBox; }
}
