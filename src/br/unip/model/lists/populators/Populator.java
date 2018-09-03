package br.unip.model.lists.populators;

import br.unip.model.items.Item;
import br.unip.model.lists.VectorList;
import br.unip.model.sorters.QuickSorter;
import br.unip.model.sorters.Sorter;

public abstract class Populator<Type extends Item> {
    
    private Sorter generatorSorter;
    private final String itemType;
    
    public Populator(String itemType){
	this(itemType, new QuickSorter());
    }

    public Populator(String itemType, Sorter generatorSorter) {
	this.generatorSorter = generatorSorter;
	this.itemType = itemType;
    }

    public void populateRandom (VectorList<Type> list){
	for(int i=list.getNumItems(); i<list.getMaxItems(); i++){
	    Type item = this.createItem();
	    item.generateRandom();
	    list.addItem((Type) item);
	}
    }
    
    public abstract Type createItem();
    
    public void populateOrdered (VectorList<Type> list){
	this.populateRandom(list);
	generatorSorter.sort(list.getItems(), false);
    }

    public void populateSemiOrdered (VectorList<Type> list){
	this.populateRandom(list);
	/*Pega metado inicial do vetor na lista e organiza, retornando depois à lista:*/
	int tempVectorSize = list.getNumItems()/2;
	Comparable[] tmpItems = new Comparable[tempVectorSize];
	System.arraycopy(list.getItems(), 0, tmpItems, 0, tempVectorSize);
	generatorSorter.sort(tmpItems, false);
	System.arraycopy(tmpItems, 0, list.getItems(), 0, tempVectorSize);
    }

    public String getItemType() {
	return itemType;
    }
        
}
