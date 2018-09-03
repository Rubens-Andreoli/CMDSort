package br.unip.view.inputs;

import java.util.Scanner;
import br.unip.view.output.components.SimpleText;

public final class LmtIntInput extends CmdInput{

    private final int min;
    private final int max;
    private int value;
    
    public LmtIntInput(String prompt, int max){
	this(prompt, 1, max);
    }
    
    public LmtIntInput(String prompt, int min, int max){
	super(prompt);
	this.max = max;
	this.min = min;
    }

    @Override
    protected void askInput() {
	value = new IntInput(String.format("%s (%d-%d): ", prompt, min, max)).getInput();
	scanner = new Scanner(System.in);
    }
    
    @Override
    public Integer getInput() {
	while(true){
	    askInput();
	    if(value >= min && value <= max)
		return value;
	    else
		new SimpleText(String.format("Input inválido! Valor deve estar entre %d e %d.\n\n", min, max)).print();
	}
    }
    
}
