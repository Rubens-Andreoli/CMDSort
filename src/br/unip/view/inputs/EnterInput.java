
package br.unip.view.inputs;

import br.unip.view.inputs.lang.Alerts;

public class EnterInput extends CmdInput {

    public EnterInput() {
	super(Alerts.ENTER_MSG);
    }
    
    @Override
    public Void getInput(){
	askInput();
	scanner.nextLine();
	return null;
    }
    
}
