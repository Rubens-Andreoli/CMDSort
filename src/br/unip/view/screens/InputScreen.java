package br.unip.view.screens;

import br.unip.view.inputs.CmdInput;
import br.unip.view.screens.components.TopBox;

public abstract class InputScreen<Type extends Object> extends Screen{
    
    protected final CmdInput question;
    protected Type userInput;
    
    public InputScreen(final TopBox top, final CmdInput cmdInput) {
	super(top);
	this.question = cmdInput;
    }

    public Type getUserInput() { return userInput; }

}
