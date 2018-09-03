package br.unip.view.screens;

import br.unip.view.inputs.EnterInput;
import br.unip.view.outputs.components.SimpleText;
import br.unip.view.outputs.structures.TopBox;

public abstract class Screen {
    
    protected final TopBox top;
    protected SimpleText footer;
    
    public Screen(final TopBox top){
	this.top = top;
    }
    
    public void setFooter(String footer) {
	this.footer = new SimpleText(footer);
    }
    
    public abstract void display();
    
    public void displayFooter(boolean wait){
	if(footer != null) footer.print();
	if(wait) new EnterInput().getInput();
    }
	    
}
