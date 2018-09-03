package br.unip.model.lists;

import java.io.Serializable;
import java.util.Iterator;
import br.unip.model.sorters.Sorter;

public class VectorList<Type extends Comparable & Serializable> implements Serializable, Iterable{
    private static final long serialVersionUID = 1L;

    private Type[] items;
    private final int maxItems;
    private int numItems;
    private Sorter sortMethod;
    private boolean sorted;

    public VectorList(VectorList<Type> list){
	this.items = list.items.clone();
	this.maxItems = list.maxItems;
	this.numItems = list.numItems;
    }
    
    public VectorList(int maxItems) {
	items = (Type[]) new Comparable[maxItems];
	this.maxItems = maxItems;
	numItems = 0;
	sorted = false;
    }

    public void addItem(Type item){
	if (numItems < maxItems) {
	    items[numItems] = item;
	    numItems++;
	}
    }

    public void sort(Sorter sorter, Boolean isReverse) {
	sortMethod = sorter;
	sortMethod.sort(items, isReverse);
	sorted = true;
    }

    public Type[] getItems() {
	return items;
    }

    public int getNumItems() {
	return numItems;
    }

    public int getMaxItems() {
	return maxItems;
    }

    public boolean isSorted() {
	return sorted;
    }

    public Sorter getSortMethod() {
	return sortMethod;
    }

    @Override
    public Iterator iterator() {
	Iterator<Type> iterator = new Iterator<Type>() {

	    private int currentIndex = 0;

	    @Override
	    public boolean hasNext() {
		return currentIndex < maxItems && items[currentIndex] != null;
	    }

	    @Override
	    public Type next() {
		return items[currentIndex++];
	    }

	    @Override
	    public void remove() {
		throw new UnsupportedOperationException();
	    }
	};
	return iterator;
    }

    @Override
    public String toString() {
	StringBuilder itemsInString = new StringBuilder("");
	for(int i=0; i<numItems; i++){
	   itemsInString.append(items[i].toString());
	   if(i != numItems-1) itemsInString.append(", ");
	}
	return itemsInString.toString();
    }
    
    public String toString(int maxItems){
	if(maxItems >= numItems) return this.toString();
	StringBuilder itemsInString = new StringBuilder("");
	for(int i=0, n=0; n<maxItems; i++, n++){
	   itemsInString.append(items[i].toString());
	   if(n != maxItems-1) itemsInString.append(", ");
	   if(n == maxItems/2){
	       i = numItems-(maxItems/2);
	       itemsInString.append("[...] ");
	   }
	}
	return itemsInString.toString();
    }
    
    
    
}
