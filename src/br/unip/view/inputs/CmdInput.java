package br.unip.view.inputs;

import java.util.Scanner;
import br.unip.view.outputs.components.SimpleText;

public abstract class CmdInput {
    
    protected final String prompt;
    protected Scanner scanner;
    
    public CmdInput(final String prompt){
	this.prompt = prompt;
    }
    
    protected void askInput(){
	new SimpleText(prompt).print();
	scanner = new Scanner(System.in);
    }
    
    public abstract Object getInput();
    
    public Object[] getLoopped(int repeat) {
	Object[] inputs = new Object[repeat];
	for(int i=0; i<repeat; i++){
	    inputs[i] = this.getInput();
	}
	return inputs;
    }
    
}
