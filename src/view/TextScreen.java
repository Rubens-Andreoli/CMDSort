package view;

import view.inputs.EnterInput;
import view.output.components.ClosedText;
import view.output.components.DashLine;
import view.output.components.SimpleText;
import view.output.structures.TopBox;

public class TextScreen extends Screen {
    private ClosedText text;
    
    public TextScreen(String title, String text){
	this.top = new TopBox(title);
	this.text = new ClosedText(text);
    }
    
    public TextScreen(String title, String text, String footer){
	this(title, text);
	this.footer = new SimpleText(footer);
    }
    
    @Override
    public void display(){
	top.print();
	text.print();
	new DashLine(2).print();
	this.displayFooter();
    }

    @Override
    public void displayFooter() {
	if(footer != null) footer.print();
	new EnterInput().getInput();
    }
    
}
