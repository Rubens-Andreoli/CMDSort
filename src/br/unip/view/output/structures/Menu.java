package br.unip.view.output.structures;

import br.unip.view.output.components.ClosedText;
import br.unip.view.output.CmdOutput;

public class Menu implements CmdOutput{

    private final String[] items;
    
    public Menu(String[] items){
	this.items = new String[items.length];
	for(int i=0; i<items.length; i++)
	    this.items[i] = String.format("%2d - %s", i+1, items[i].toUpperCase());
    }

    @Override
    public void print(){
	for(String item : items)
	    new ClosedText(item).print();
    }
}
