package br.unip.view;

import br.unip.view.inputs.EnterInput;
import br.unip.view.output.components.SimpleText;
import br.unip.view.output.structures.TopBox;

public abstract class Screen {
    protected TopBox top;
    protected SimpleText footer;
    
    public void setFooter(String footer) {
	this.footer = new SimpleText(footer);
    }
    
    public abstract void display();
    
    public void displayFooter(){
	if(footer != null){ 
	    footer.print();
	    new EnterInput().getInput();
	}
    };
	    
}
