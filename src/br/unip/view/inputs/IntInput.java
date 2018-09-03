package br.unip.view.inputs;

import static br.unip.view.Configs.INT_ERROR;
import br.unip.view.Builder;
import br.unip.view.outputs.SimpleText;

public class IntInput extends CmdInput<Integer> {

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
		Builder.build(new SimpleText(INT_ERROR)).println();
	}
    }

}
