package model.list;

import java.io.Serializable;
import model.Items.Item;

public abstract class ItemList<ItemType extends Item> implements Serializable{

    protected ItemType[] items;
    protected int maxSize;
    protected int numItems;
    protected final boolean sorted;

    public ItemList(int maxSize) {
	items = (ItemType[]) new Item[maxSize];
	this.maxSize = maxSize;
	numItems = 0;
	sorted = false;
    }

    public void addItem(ItemType item){
	if (numItems < maxSize) {
	    items[numItems] = item;
	    numItems++;
	}else{
	    //lista cheia!
	}
    }

    public Item[] getItems() {
	return items;
    }

    public int getNumItems() {
	return numItems;
    }

    public boolean isSorted() {
	return sorted;
    }

    public int getMaxSize() {
	return maxSize;
    }
    
    public abstract void populateRandom();
    
    public abstract void pupulateOrdered();

}
