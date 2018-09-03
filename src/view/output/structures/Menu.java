package view.output.structures;

import view.output.components.ClosedText;
import view.output.CmdOutput;

public class Menu implements CmdOutput{

    private String[] items;
    private int numItems;
    
    protected Menu(){}
    
    public Menu(String[] items){
	this.items = new String[items.length];
	for(numItems=0; numItems<items.length; numItems++)
	    this.items[numItems] = String.format("%2d - %s", numItems+1, items[numItems].toUpperCase());
    }
    
    protected void setItems(String[] items) {
	this.items = items;
    }

    public int getNumItems() {
	return numItems;
    } 

    protected void setNumItems(int numItems) {
	this.numItems = numItems;
    }

    @Override
    public void print(){
	for(String item : items)
	    new ClosedText(item).print();
    }
}
