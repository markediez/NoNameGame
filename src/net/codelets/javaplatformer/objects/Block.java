package net.codelets.javaplatformer.objects;

import net.codelets.javaplatformer.entities.Entity;
import net.codelets.javaplatformer.gamestates.GameState;

import java.awt.*;

/**
 * Created by Mark Diez on 8/5/2015.
 */
public class Block extends Entity {
    // Properties
    public static final int BLOCK_SIZE = 48;
    // Constructors
    private Rectangle collisionBox;
    private boolean doesExist;
    private int id;

    public Block(int posX, int posY, int id) {
        super(posX, posY);
        this.collisionBox = new Rectangle(posX, posY, BLOCK_SIZE, BLOCK_SIZE);
        this.id = id;
    }

    // Methods
    @Override
    public void init() {

    }

    @Override
    public void update(Block[][] blocks) {
        if(this.id == 0) {
            this.doesExist = false;
            this.collisionBox.setLocation(0,0);
        } else {
            this.doesExist = true;
            this.collisionBox.setLocation((int) posX - (int) GameState.xOffset, (int) posY - (int) GameState.yOffset);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GRAY);
        if(this.doesExist) {
            g.fillRect((int) posX - (int) GameState.xOffset, (int) posY - (int) GameState.yOffset, BLOCK_SIZE, BLOCK_SIZE);
        }
    }


    public Rectangle getCollisionBox() { return this.collisionBox; }
}
