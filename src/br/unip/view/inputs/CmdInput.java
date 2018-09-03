package br.unip.view.inputs;

import br.unip.view.Builder;
import java.util.Scanner;
import br.unip.view.outputs.SimpleText;

public abstract class CmdInput<Type extends Object> {
    
    protected final String prompt;
    protected Scanner scanner;
    
    public CmdInput(final String prompt){
	this.prompt = prompt;
    }

    protected void askInput(){
	Builder.build(new SimpleText(prompt)).print();
	scanner = new Scanner(System.in);
    }

    public abstract Type getInput();
    
}
