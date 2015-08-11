package net.codelets.javaplatformer.items;

/**
 * Created by Mark on 8/11/2015.
 */
public class Weapon extends Item {
    private int attackMax;
    private int attackMin;

    public Weapon() {
        super("Unidentified Weapon", "It doesn't look cursed...");
        this.attackMax = 2;
        this.attackMin = 1;
    }

    public Weapon(String name, String description, int attackMax, int attackMin) {
        super(name, description);
        this.attackMin = attackMin;
        this.attackMax = attackMax;
    }

}
