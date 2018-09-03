package br.unip.view;

import br.unip.view.inputs.EnterInput;
import br.unip.view.output.components.CharLine;
import br.unip.view.output.components.ClosedText;
import br.unip.view.output.components.SimpleText;
import br.unip.view.output.structures.TopBox;

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
	new CharLine(2).print();
	this.displayFooter();
    }

    @Override
    public void displayFooter() {
	if(footer != null) footer.print();
	new EnterInput().getInput();
    }
    
}
