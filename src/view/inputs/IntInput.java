package view.inputs;

import view.output.components.SimpleText;

public final class IntInput extends CmdInput {

    public IntInput(String prompt) {
	super(prompt);
    }
    
    @Override
    public Integer getInput(){
	while(true){
	    askInput();
	    if(scanner.hasNextInt()) 
		return scanner.nextInt();
	    else 
		new SimpleText("Input inválido! Digite um número inteiro.\n\n").print();
	}
    }
    
}
