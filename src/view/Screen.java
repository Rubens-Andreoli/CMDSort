package view;

import view.inputs.EnterInput;
import view.output.components.SimpleText;
import view.output.structures.TopBox;

public abstract class Screen {
    protected TopBox title;
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
