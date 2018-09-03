package br.unip.view.inputs;

import static br.unip.view.Configs.ENTER_PROMPT;

public class EnterInput extends CmdInput<Void> {

    public EnterInput() {
	super(ENTER_PROMPT);
    }
    
    @Override
    public Void getInput(){
	askInput();
	scanner.nextLine();
	return null;
    }

}
