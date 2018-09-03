package br.unip.view.inputs;

import br.unip.view.inputs.lang.Alerts;
import br.unip.view.outputs.components.SimpleText;

public class IntInput extends CmdInput {

    public IntInput(final String prompt) {
	super(prompt);
    }
    
    @Override
    public Integer getInput(){
	while(true){
	    askInput();
	    if(scanner.hasNextInt()) 
		return scanner.nextInt();
	    else 
		new SimpleText(Alerts.INT_ERROR).print();
	}
    }

}
