package br.unip.view.inputs;

import static br.unip.view.Configs.STRING_ERROR;
import br.unip.view.Builder;
import br.unip.view.outputs.SimpleText;

public class StringInput extends CmdInput<String> {

    private final String regex;
    
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
	    else Builder.build(new SimpleText(STRING_ERROR)).println();
	}
    }

}
