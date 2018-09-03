package br.unip.view.inputs;

import br.unip.view.output.components.SimpleText;

public class BooleanInput extends CmdInput{
    private final char isTrue; 
    private final char isFalse;
    
    public BooleanInput(String prompt) {
	this(prompt, 's', 'n');
    }
    
    public BooleanInput(String prompt, char isTrue, char isFalse){
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
	    new SimpleText("Input inválido! Digite uma opção.\n\n").print();
	}
    }
    
}
