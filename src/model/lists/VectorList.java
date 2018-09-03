package model.lists;

import java.io.File;
import java.io.Serializable;
import java.util.Iterator;
import model.FileIO;
import model.sorters.Sorter;

public class VectorList<Type extends Comparable> implements Serializable, Iterable {
    private static final long serialVersionUID = 1L;

    private Comparable[] items;
    private final int maxItems;
    private int numItems;
    private String sortMethod;
    private boolean sorted;

    public VectorList(int maxItems) {
	items = new Comparable[maxItems];
	this.maxItems = maxItems;
	numItems = 0;
	sorted = false;
    }

    public void addItem(Type item) {
	if (numItems < maxItems) {
	    items[numItems] = item;
	    numItems++;
	} else {
	    //lista cheia!
	}
    }

    public void sort(Sorter sorter, Boolean isReverse) {
	sorter.sort(items, numItems, isReverse);
	sortMethod = sorter.getMethodName();
	sorted = true;
    }

    public Comparable[] getItems() {
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

    @Override
    public Iterator iterator() {
	Iterator<Comparable> iterator = new Iterator<Comparable>() {

	    private int currentIndex = 0;

	    @Override
	    public boolean hasNext() {
		return currentIndex < maxItems && items[currentIndex] != null;
	    }

	    @Override
	    public Comparable next() {
		return items[currentIndex++];
	    }

	    @Override
	    public void remove() {
		throw new UnsupportedOperationException();
	    }
	};
	return iterator;
    }
    
    public void writeToFile(File file){
	new FileIO().write(this, file);
    }
}
