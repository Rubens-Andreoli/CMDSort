package br.unip.view.inputs;

import java.util.Scanner;
import br.unip.view.output.components.SimpleText;

public abstract class CmdInput {
    
    protected final String prompt;
    protected Scanner scanner;
    
    public CmdInput(String prompt){
	this.prompt = prompt;
    }
    
    protected void askInput(){
	new SimpleText(prompt).print();
	scanner = new Scanner(System.in);
    }
    
    public abstract Object getInput();
    
}
