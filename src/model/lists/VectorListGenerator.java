package model.lists;

import model.items.Item;
import model.items.ItemFactory;
import model.items.ItemTypes;
import model.lists.exceptions.FullListException;
import model.sorters.BubbleSorter;
import model.sorters.Sorter;

public class VectorListGenerator {
    
    private Sorter generatorSorter;
    
    public VectorListGenerator(){
	generatorSorter = new BubbleSorter();
    }

    public VectorListGenerator(Sorter generatorSorter) {
	this.generatorSorter = generatorSorter;
    }

    public void populateRandom (ItemTypes itemType, VectorList list, int numItems) throws FullListException{
	ItemFactory itemFactory = new ItemFactory();
	for(int i=list.getNumItems(); i<list.getMaxItems() && i<numItems; i++){
	    Item item = itemFactory.createItem(itemType);
	    item.generateRandom();
	    list.addItem(item);
	}
    }
    
    public void populateOrdered (ItemTypes itemType, VectorList list, int numItems) throws FullListException{
	this.populateRandom(itemType, list, numItems);
	generatorSorter.sort(list.getItems(), list.getNumItems(), false);
    }
    
    public void populateSemiOrdered (ItemTypes itemType, VectorList list, int numItems) throws FullListException{
	this.populateRandom(itemType, list, numItems);
	int tempVectorSize = list.getNumItems()/2;
	
	Comparable[] tmpItems = new Comparable[tempVectorSize];
	System.arraycopy(list.getItems(), 0, tmpItems, 0, tempVectorSize);
	generatorSorter.sort(tmpItems, tempVectorSize, false);
	System.arraycopy(tmpItems, 0, list.getItems(), 0, tempVectorSize);
    }
    
}
