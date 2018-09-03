package br.unip.model.items.generators;

import br.unip.model.items.Item;
import br.unip.model.sorters.QuickSorter;

public abstract class ItemGenerator<Type extends Item> {
    
    public abstract String getItemType(); 
    
    protected abstract Type generateItem();
    
    protected abstract Type[] generateVector(int numItems);
    
    public Type[] generateRandom(int numItems){
	Type[] items = this.generateVector(numItems);
	for(int i=0; i<items.length; i++){
	    items[i] = this.generateItem();
	    items[i].generateRandom();
	}
	return items;
    }
    
    public Type[] generateOrdered(int numItems){
	Type[] items = this.generateRandom(numItems);
	new QuickSorter().sort(items, false);
	return items;
    }
    
    public Type[] generateSemiOrdered(int numItems){
	Type[] items = this.generateRandom(numItems);
	int tempVectorSize = numItems/2;
	Comparable[] tmpItems = new Comparable[tempVectorSize];
	System.arraycopy(items, 0, tmpItems, 0, tempVectorSize);
	new QuickSorter().sort(tmpItems, false);
	System.arraycopy(tmpItems, 0, items, 0, tempVectorSize);
	return items;
    }
    
}
