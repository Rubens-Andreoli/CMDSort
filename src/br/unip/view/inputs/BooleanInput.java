package br.unip.view.inputs;

import static br.unip.view.Configs.*;
import br.unip.view.Builder;
import br.unip.view.outputs.SimpleText;

public class BooleanInput extends CmdInput<Boolean>{
    
    private final char isTrue; 
    private final char isFalse;
    
    public BooleanInput(final String prompt) {
	this(prompt, DFLT_BOOLEAN_YES, DFLT_BOOLEAN_NO);
    }

    public BooleanInput(final String prompt, final char isTrue, final char isFalse){
	super(prompt);
	this.isTrue = isTrue;
	this.isFalse = isFalse;
    }

    @Override
    public Boolean getInput() {
	char inputChar;
	String inputWord;
	while(true){
	    askInput();
	    if(scanner.hasNextLine()){ 
		inputWord = scanner.nextLine().toLowerCase();
		if(inputWord.length()>0){
		    inputChar = inputWord.charAt(0);
		    if(inputChar == isTrue)
			return true;
		    else if(inputChar == isFalse)
			return false;
		}
	    }
	    Builder.build(new SimpleText(BOOLEAN_ERROR)).println();
	}
    }

    
}
