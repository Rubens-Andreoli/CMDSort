package br.unip.view.screens;

import br.unip.view.Builder;
import br.unip.view.inputs.EnterInput;
import br.unip.view.screens.components.TopBox;
import br.unip.view.screens.components.Footer;

public abstract class Screen {
    
    protected final TopBox top;
    protected Footer footer;
    
    public Screen(final TopBox top){
	this.top = top;
    }
    
    public abstract void display();
    
    public void setFooter(String msg){ footer = Builder.build(new Footer(msg)); }
    
    public void displayFooter(boolean isPrintln){
	if(isPrintln) footer.println();
	else footer.print();
    }
    
    public void waitEnter(){
	new EnterInput().getInput();
    }
	    
}
