package model.lists;

import model.items.Item;
import model.items.ItemFactory;
import model.items.ItemTypes;
import model.sorters.BubbleSorter;
import model.sorters.Sorter;

public class VectorListGenerator {
    
    public void populateRandom (ItemTypes itemType, VectorList list, int numItems){
	ItemFactory itemFactory = new ItemFactory();
	for(int i=list.getNumItems(); i<list.getMaxItems() && i<numItems; i++){
	    Item item = itemFactory.createItem(itemType);
	    item.generateRandom();
	    list.addItem(item);
	}
    }
    public void populateOrdered (ItemTypes itemType, VectorList list, int numItems){
	this.populateRandom(itemType, list, numItems);
	list.sort(new BubbleSorter(), Boolean.FALSE);
    }
    public void populateSemiOrdered (ItemTypes itemType, VectorList list, int numItems){
	this.populateRandom(itemType, list, numItems);
	int tempVectorSize = list.getNumItems()/2;
	Sorter bubble = new BubbleSorter();
	
	Comparable[] tmpItems = new Comparable[tempVectorSize];
	for(int i=0; i<tempVectorSize; i++){
	    tmpItems[i] = list.getItems()[i];
	}
	bubble.sort(tmpItems, tempVectorSize, false);
	for(int i=0; i<tempVectorSize; i++){
	    list.getItems()[i] = tmpItems[i];
	}

    }
}
