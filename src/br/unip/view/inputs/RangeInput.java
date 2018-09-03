package br.unip.view.inputs;

import java.util.Scanner;
import br.unip.view.Builder;
import br.unip.view.outputs.SimpleText;
import static br.unip.view.Configs.RANGE_ERROR;
import static br.unip.view.Configs.RANGE_MASK;

public class RangeInput extends CmdInput<Integer>{

    private final int min;
    private final int max;
    private int input;
    
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
	input = new IntInput(String.format(RANGE_MASK, prompt, min, max)).getInput();
	scanner = new Scanner(System.in);
    }
    
    @Override
    public Integer getInput() {
	while(true){
	    askInput();
	    if(input >= min && input <= max) return input;
	    else Builder.build(new SimpleText(String.format(RANGE_ERROR, min, max))).println();
	}
    }
    
}
