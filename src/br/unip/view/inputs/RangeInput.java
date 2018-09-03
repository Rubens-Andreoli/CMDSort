package br.unip.view.inputs;

import br.unip.view.inputs.lang.Alerts;
import java.util.Scanner;
import br.unip.view.outputs.components.SimpleText;

public class RangeInput extends CmdInput{

    private final int min;
    private final int max;
    private int value;
    
    public RangeInput(final String prompt, final int max){
	this(prompt, 1, max);
    }
    
    public RangeInput(final String prompt, final int min, final int max){
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
		new SimpleText(String.format(Alerts.LMTINT_ERROR, min, max)).print();
	}
    }
    
}
