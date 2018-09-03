package br.unip.view.screens;

import br.unip.view.Builder;
import br.unip.view.outputs.BoxedText;
import br.unip.view.outputs.CharLine;
import br.unip.view.outputs.CmdText;
import br.unip.view.screens.components.*;

public class TextScreen extends Screen {
    
    private final CmdText text;

    public TextScreen(final String title, final String text){
	super(Builder.build(new TopBox(title)));
	this.text = Builder.build(new BoxedText(text));
    }
    
    public TextScreen(final String title, final String text, String footer){
	this(title, text);
	this.footer = Builder.build(new Footer(footer));
    }
    
    @Override
    public void display(){
	top.println();
	text.println();
	Builder.build(new CharLine(2)).println();
	if(footer != null) footer.println();
	this.waitEnter();
    }
    
}
