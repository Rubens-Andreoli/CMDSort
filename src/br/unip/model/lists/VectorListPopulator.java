package br.unip.model.lists;

import br.unip.model.items.Item;
import br.unip.model.items.ItemFactory;
import br.unip.model.items.ItemTypes;
import br.unip.model.lists.exceptions.FullListException;
import br.unip.model.sorters.BubbleSorter;
import br.unip.model.sorters.Sorter;

public class VectorListPopulator {
    
    private Sorter generatorSorter;
    
    public VectorListPopulator(){
	this(new BubbleSorter());
    }

    public VectorListPopulator(Sorter generatorSorter) {
	this.generatorSorter = generatorSorter;
    }

    public void populateRandom (ItemTypes itemType, VectorList list){
	this.populateRandom(itemType, list, list.getMaxItems());
    }
   
    public void populateRandom (ItemTypes itemType, VectorList list, int numItems){
	ItemFactory itemFactory = new ItemFactory();
	for(int i=list.getNumItems(); i<list.getMaxItems() && i<numItems; i++){
	    Item item = itemFactory.createItem(itemType);
	    item.generateRandom();
	    try {
		list.addItem(item);
	    } catch (FullListException ex) {/*Catch nunca será executado!*/}
	}
    }
    
    public void populateOrdered (ItemTypes itemType, VectorList list){
	this.populateOrdered(itemType, list, list.getMaxItems());
    }
    
    public void populateOrdered (ItemTypes itemType, VectorList list, int numItems){
	this.populateRandom(itemType, list, numItems);
	generatorSorter.sort(list.getItems(), list.getNumItems(), false);
    }
    
    public void populateSemiOrdered (ItemTypes itemType, VectorList list){
	this.populateSemiOrdered(itemType, list, list.getMaxItems());
    }
    
    public void populateSemiOrdered (ItemTypes itemType, VectorList list, int numItems){
	this.populateRandom(itemType, list, numItems);
	int tempVectorSize = list.getNumItems()/2;
	
	Comparable[] tmpItems = new Comparable[tempVectorSize];
	System.arraycopy(list.getItems(), 0, tmpItems, 0, tempVectorSize);
	generatorSorter.sort(tmpItems, tempVectorSize, false);
	System.arraycopy(tmpItems, 0, list.getItems(), 0, tempVectorSize);
    }
    
}
