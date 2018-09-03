package br.unip.view.screens;

import br.unip.view.inputs.CmdInput;
import br.unip.view.outputs.structures.TopBox;

public abstract class InputScreen<Type extends Object> extends Screen{
    
    protected final CmdInput prompt;
    protected Type userInput;

    public InputScreen(final TopBox top, final CmdInput prompt) {
	super(top);
	this.prompt = prompt;
    }
    
    public Type getUserInput(){
	return userInput;
    }
    
    public Object extraQuestion(CmdInput input){
	return input.getInput();
    }
    
}
