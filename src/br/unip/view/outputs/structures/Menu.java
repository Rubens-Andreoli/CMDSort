package br.unip.view.outputs.structures;

import br.unip.view.outputs.components.ClosedText;
import br.unip.view.outputs.CmdOutput;

public class Menu implements CmdOutput{

    private final String[] items;
    
    public Menu(final String[] items){
	this.items = items;
	for(int i=0; i<items.length; i++)
	    this.items[i] = String.format("%2d - %s", i+1, items[i].toUpperCase());
    }

    @Override
    public void print(){
	for(String item : items)
	    new ClosedText(item).print();
    }
}
