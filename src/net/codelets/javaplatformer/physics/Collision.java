package net.codelets.javaplatformer.physics;

import net.codelets.javaplatformer.entities.Entity;

/**
 * Created by Mark Diez on 8/5/2015.
 */
public class Collision {
    /**
     * isColliding
     * @param a - An Entity
     * @param b - Another Entity
     * @return  - returns true if the entities touch each other
     */
    public static boolean isColliding(Entity a, Entity b) {
        double dX = a.getCollisionBox().getX() - b.getCollisionBox().getX();
        double dY = a.getCollisionBox().getY() - b.getCollisionBox().getY();
        if((dX <= a.getCollisionBox().getWidth() && dX >= -a.getCollisionBox().getWidth())
                && (dY <= a.getCollisionBox().getHeight() && dY >= -a.getCollisionBox().getHeight())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean topCollision(Entity a, Entity b) {
        double x = a.getCollisionBox().getX();
        double y = a.getCollisionBox().getY() - 2;
        if(b.getCollisionBox().contains(x, y)
                || b.getCollisionBox().contains(x + a.getCollisionBox().getWidth(), y)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean botCollision(Entity a, Entity b) {
        double x = a.getCollisionBox().getX();
        double y = a.getCollisionBox().getY() + a.getCollisionBox().getHeight() + 2;
        if(b.getCollisionBox().contains(x, y)
                || b.getCollisionBox().contains(x + a.getCollisionBox().getWidth(), y)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean leftCollision(Entity a, Entity b) {
        double x = a.getCollisionBox().getX() - 2;
        double y = a.getCollisionBox().getY();
        if(b.getCollisionBox().contains(x, y)
                || b.getCollisionBox().contains(x, y + a.getCollisionBox().getHeight())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean rightCollision(Entity a, Entity b) {
        double x = a.getCollisionBox().getX() + 2;
        double y = a.getCollisionBox().getY() ;
        if(b.getCollisionBox().contains(x + a.getCollisionBox().getWidth(), y)
                || b.getCollisionBox().contains(x + a.getCollisionBox().getWidth(), y + a.getCollisionBox().getHeight())) {
            return true;
        } else {
            return false;
        }
    }
}
