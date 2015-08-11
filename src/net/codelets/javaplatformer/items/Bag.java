package net.codelets.javaplatformer.items;

/**
 * Created by Mark on 8/11/2015.
 */
public class Bag extends Item{
    private Item[] items;
    private int maxLoad;
    private int currentLoad;

    public Bag() {
        super();
        this.maxLoad = 5;
        this.currentLoad = 0;
        this.items = new Item[maxLoad];
    }

    public Bag(String name, String description, int maxLoad) {
        super(name, description);
        this.maxLoad = maxLoad;
        this.currentLoad = 0;
        this.items = new Item[maxLoad];
    }

    public void add(Item newItem) {
        if(currentLoad < maxLoad) {
            this.items[currentLoad] = newItem;
            currentLoad++;
        } else {
            System.out.println("Inventory Full");
        }
    }

    public void remove(int index) {
        this.items[index] = null;
        // Shifts the items
        for(int i = index; i < currentLoad; i++) {
            this.items[i] = this.items[i+1];
        }
        currentLoad--;
    }

    public Item get(int index) {
        return this.items[index];
    }

    // Getters & Setters
    public Item[] getItems() { return this.items; }
    public int getCurrentLoad() { return this.currentLoad; }
    public int getMaxLoad() { return this.maxLoad; }
}
