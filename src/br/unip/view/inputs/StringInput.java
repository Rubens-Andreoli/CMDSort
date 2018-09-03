package br.unip.view.inputs;

import br.unip.view.inputs.lang.Alerts;
import br.unip.view.outputs.components.SimpleText;

public class StringInput extends CmdInput {

    private String regex;
    
    public StringInput(final String prompt, final String regex) {
	super(prompt);
	this.regex = regex;
    }
    
    @Override
    public String getInput(){
	String word;
	while(true){
	    askInput();
	    word = scanner.nextLine();
	    word = word.trim();
	    if(word.matches(regex)) return word;
	    else new SimpleText(Alerts.STRING_ERROR).print();
	}
    }
    
}
