package view.inputs;

import view.output.components.SimpleText;

public final class WordInput extends CmdInput {

    public WordInput(String prompt) {
	super(prompt);
    }
    
    @Override
    public String getInput(){
	String word;
	while(true){
	    askInput();
	    word = scanner.nextLine();
	    word = word.trim();
	    if(word.length()>2 && word.matches("[a-zA-Z]+"))
		return word;
	    else
		new SimpleText("Input inválido! Digite UMA palavra.\n\n").print();
	}
    }
    
}
