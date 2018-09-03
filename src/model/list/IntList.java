package model.list;

import model.Items.IntItem;

public class IntList extends ItemList<IntItem>{

    public IntList(int maxSize) {
	super(maxSize);
    }

    @Override
    public void populateRandom() {
	for(int i=0; i<maxSize; i++){
	    IntItem item = new IntItem();
	    item.generateRandom();
	    super.addItem(item);
	}
    }

    @Override
    public void pupulateOrdered() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
