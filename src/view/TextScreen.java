package view;

import view.inputs.EnterInput;
import view.output.components.ClosedText;
import view.output.components.DashLine;
import view.output.components.SimpleText;
import view.output.structures.TopBox;

public class TextScreen extends Screen {
    private ClosedText text;
    
    public TextScreen(String title, String text){
	this.title = new TopBox(title, 2);
	this.text = new ClosedText(text);
    }
    
    public TextScreen(String title, String text, String footer){
	this(title, text);
	this.footer = new SimpleText(footer);
    }
    
    public void display(){
	title.print();
	text.print();
	new DashLine(2).print();
	this.displayFooter();
    }

    @Override
    public void displayFooter() {
	if(footer != null) footer.print();
	new EnterInput();
    }
    
}
