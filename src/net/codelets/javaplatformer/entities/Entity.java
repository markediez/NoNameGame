package net.codelets.javaplatformer.entities;

import net.codelets.javaplatformer.objects.Block;

import java.awt.*;

/**
 * Created by Mark Diez on 8/4/2015.
 */
public abstract class Entity {
    protected String name;
    protected int health;
    protected int speed;
    protected double posX;
    protected double posY;
    protected Rectangle collisionBox;

    public Entity(int posX, int posY) {
        this.name = "Unknown";
        this.health = 100;
        this.speed = 1;
        this.posX = posX;
        this.posY = posY;
        this.collisionBox = new Rectangle(posX, posY, 32, 32);
        this.init();
    }

    public abstract void init();
    public abstract void draw(Graphics g);
    public abstract void update(Block[] blocks);

    public Rectangle getCollisionBox() { return this.collisionBox; }
}
