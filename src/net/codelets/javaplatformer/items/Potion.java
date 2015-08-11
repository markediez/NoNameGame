package net.codelets.javaplatformer.items;

/**
 * Created by Mark on 8/11/2015.
 */
public class Potion extends Item {
    private int value;

    public Potion() {
        super("Unidentified Potion", "Drink if you dare");
        this.value = 100;
    }

    public Potion(String name, String description, int value) {
        super(name, description);
        this.value = value;
    }


    // Setters & Getters
    public int getValue() { return value; }
}
