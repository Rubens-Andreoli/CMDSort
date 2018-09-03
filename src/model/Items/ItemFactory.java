package model.items;

public class ItemFactory {
    
    public Item createItem(ItemTypes itemType){
	switch(itemType){
	    case INTITEM:
		return new IntItem();
	    case MISCITEM:
		return new MiscItem();
	    default:
		return null;
	
	}
    }
    
}
