package model.list;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import model.Items.Item;

public class VectorList<ItemType extends Item> implements Serializable {
    //private final Class clss;
    protected ItemType[] items;
    protected int maxItems;
    protected int numItems;
    protected final boolean sorted;
    
    public VectorList(/*Class<ItemType> clss,*/ int maxSize) {
	//this.clss = clss;
	items = (ItemType[]) new Item[maxSize];
	this.maxItems = maxSize;
	numItems = 0;
	sorted = false;
    }
    
    public void addItem(ItemType item){
	if (numItems < maxItems) {
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
	return maxItems;
    }
    
    public void populateRandom() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
	for(int i=0; i<maxItems; i++){
	    /*try {
		ItemType item = (ItemType)clss.newInstance();
		item.generateRandom();
		this.addItem(item);
	    } catch (InstantiationException | IllegalAccessException ex) {
		//Logger.getLogger(VectorList.class.getName()).log(Level.SEVERE, null, ex);
	    }*/
	   ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
	   String parameterClassName = pt.getActualTypeArguments()[0].toString().split("\\s")[1];
	   ItemType item = (ItemType) Class.forName(parameterClassName).newInstance();
	   item.generateRandom();
	   this.addItem(item);
	}
    }
    
    public void pupulateOrdered(){
    
    }
}
