package net.codelets.javaplatformer.entities;

import net.codelets.javaplatformer.gamestates.GameState;
import net.codelets.javaplatformer.objects.Block;
import net.codelets.javaplatformer.physics.Collision;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Mark Diez on 8/4/2015.
 */
public class Player extends Entity {
    // Properties
    private boolean moveLeft, moveRight, falling, jumping, botCollision;
    private double jumpSpeed, fallSpeed, currentJumpSpeed, currentFallSpeed;
    // Constructors
    public Player(int posX, int posY) {
        super(posX, posY);
        this.collisionBox = new Rectangle(posX, posY, 32, 32);
    }

    // Methods
    @Override
    public void init() {
        this.moveLeft = false;
        this.moveRight = false;
        this.falling = false;
        this.jumping = false;
        this.botCollision = false;
        this.jumpSpeed = 5;
        this.fallSpeed = 0.1;
        this.currentFallSpeed = this.fallSpeed;
        this.currentJumpSpeed = this.jumpSpeed;
    }

    @Override
    public void update(Block[] blocks) {
        collision(blocks);
        movement();
        botCollision = false;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)posX, (int)posY, 32, 32);
    }

    public void keyPressed(int key) {
        switch(key) {
            case KeyEvent.VK_W:
                //this.jumping = true; // future climb up
                break;
            case KeyEvent.VK_S:
                //this.moveDown = true; // future climb down
                break;
            case KeyEvent.VK_A:
                this.moveLeft = true;
                break;
            case KeyEvent.VK_D:
                this.moveRight = true;
                break;
            case KeyEvent.VK_SPACE:
                this.jumping = true;
                break;
        }
    }

    public void keyReleased(int key) {
        switch(key) {
            case KeyEvent.VK_W:
                //this.moveUp = false; // future stop climb up
                break;
            case KeyEvent.VK_S:
                //this.moveDown = false; // future stop climb down
                break;
            case KeyEvent.VK_A:
                this.moveLeft = false;
                break;
            case KeyEvent.VK_D:
                this.moveRight = false;
                break;
        }
    }

    private void movement() {
        if(moveLeft) GameState.xOffset -= this.speed;
        if(moveRight) GameState.xOffset += this.speed;
        if(jumping) {
            GameState.yOffset -= currentJumpSpeed;
            currentJumpSpeed -= 0.1;
            if(currentJumpSpeed <= 0) {
                falling = true;
                jumping = false;
                currentJumpSpeed = 5;
            }
        }
        if(falling) {
            GameState.yOffset += currentFallSpeed;
            currentFallSpeed += 0.1;
        }
    }

    private void collision(Block[] blocks) {
        for(int i = 0; i < blocks.length; i++) {
            if(Collision.topCollision(this, blocks[i])) currentJumpSpeed = 0;
            if(Collision.leftCollision(this, blocks[i]))  moveLeft = false;
            if(Collision.rightCollision(this, blocks[i])) moveRight = false;
            if(Collision.botCollision(this, blocks[i])) {
                falling = false;
                botCollision = true;
                currentFallSpeed = 0.1;
                // avoid sinking
                if(Collision.isColliding(this, blocks[i])) GameState.yOffset--;
            } else {
                if(!jumping && !botCollision) {
                    falling = true;
                }
            }
        }
    }
}
