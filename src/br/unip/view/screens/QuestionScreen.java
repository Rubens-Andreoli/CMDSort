package br.unip.view.screens;

import br.unip.view.Builder;
import br.unip.view.inputs.CmdInput;
import br.unip.view.outputs.CharLine;
import br.unip.view.screens.components.TopBox;

public class QuestionScreen<Type extends Object> extends InputScreen<Type>{
    
    public QuestionScreen(final String title, final CmdInput cmdInput){
	super(Builder.build(new TopBox(title)), cmdInput);
    }
 
    @Override
    public void display() {
	top.println();
	Builder.build(new CharLine()).println();
	userInput = (Type) question.getInput();
    }
    
}
