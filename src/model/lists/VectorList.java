package model.lists;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import model.FileIO;
import model.items.Item;
import model.lists.exceptions.EmptyListException;
import model.lists.exceptions.FullListException;
import model.sorters.Sorter;

public class VectorList<Type extends Item> implements Serializable, Iterable {
    private static final long serialVersionUID = 1L;

    private Type[] items;
    private final int maxItems;
    private int numItems;
    private String sortMethod;
    private boolean sorted;

    public VectorList(int maxItems) {
	items = (Type[]) new Item[maxItems];
	this.maxItems = maxItems;
	numItems = 0;
	sorted = false;
    }

    public void addItem(Type item) throws FullListException {
	if (numItems < maxItems) {
	    items[numItems] = item;
	    numItems++;
	} else throw new FullListException();
    }

    public void sort(Sorter sorter, Boolean isReverse) throws EmptyListException {
	if(numItems == 0) throw new EmptyListException();
	sorter.sort(items, numItems, isReverse);
	sortMethod = sorter.getMethodName();
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

    public String getSortMethod() {
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
    
    public void writeToFile(File file) throws IOException{
	new FileIO().write(this, file);
    }
}
