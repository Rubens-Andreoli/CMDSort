package view.output.structures;

import view.output.components.ClosedText;
import view.output.CmdOutput;

public class Menu implements CmdOutput{

    private final String items[];
    
    public Menu(String items[]){
	this.items = items;
    }

    @Override
    public void print(){
	for(int i=0; i<items.length /*&& i<MAX_ITEMS*/; i++)
	    new ClosedText(String.format("%2d - %s", i+1, items[i])).print();
    }
}
