package br.unip.view.screens.components;

import br.unip.view.Buildable;
import static br.unip.view.Configs.DFLT_ALIGNMENT;
import br.unip.view.Builder;
import br.unip.view.outputs.BoxedText;
import static br.unip.view.Configs.MENU_MASK;
import br.unip.view.outputs.CmdOutput;

public class Menu implements Buildable{

    private final String[] items;
    private CmdOutput[] outputs;
    
    public Menu(final String[] items){
	this.items = items;
    }
    
    @Override
    public void build(){
	this.outputs = new CmdOutput[items.length];
	for(int i=0; i<items.length; i++)
	    outputs[i] = Builder.build(new BoxedText(String.format(MENU_MASK, i+1, 
		    items[i].toUpperCase()), DFLT_ALIGNMENT));
    }

    public void println() {
	for(CmdOutput item : outputs) item.println();
    }
    
}
