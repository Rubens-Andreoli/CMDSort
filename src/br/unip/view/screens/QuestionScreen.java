package br.unip.view.screens;

import br.unip.view.inputs.CmdInput;
import br.unip.view.outputs.structures.TopBox;

public class QuestionScreen<Type extends Object> extends InputScreen<Type>{
    
    public QuestionScreen(final String title, final CmdInput cmdInput){
	super(new TopBox(title, 2), cmdInput);
    }

    @Override
    public void display() {
	top.print();
	userInput = (Type) prompt.getInput();
    }
    
}
