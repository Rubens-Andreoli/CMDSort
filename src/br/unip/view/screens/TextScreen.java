package br.unip.view.screens;

import br.unip.view.outputs.components.CharLine;
import br.unip.view.outputs.components.ClosedText;
import br.unip.view.outputs.components.SimpleText;
import br.unip.view.outputs.structures.TopBox;

public class TextScreen extends Screen {
    
    private final ClosedText text;
    
    public TextScreen(final String title, final String text){
	super(new TopBox(title));
	this.text = new ClosedText(text);
    }
    
    public TextScreen(final String title, final String text, String footer){
	this(title, text);
	this.footer = new SimpleText(footer);
    }
    
    @Override
    public void display(){
	top.print();
	text.print();
	new CharLine(2).print();
	this.displayFooter(true);
    }
    
}
