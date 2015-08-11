package net.codelets.javaplatformer.items;

/**
 * Created by Mark on 8/11/2015.
 */
public abstract class Item {
    private String name;
    private String description;

    public Item() {
        this.name = "Unknown";
        this.description = "N/A";
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String inspect() {
        return getName() + ", " + getDescription();
    }

    // getters & setters
    public String getName() { return this.name; }
    public String getDescription() { return this.description; }
}
