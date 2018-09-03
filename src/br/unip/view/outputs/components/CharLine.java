package br.unip.view.outputs.components;

import br.unip.view.outputs.CmdOutput;

public class CharLine implements CmdOutput {
    
    private final StringBuilder line;
    private final int numLines;
	
    public CharLine(){
	this(1);
    }
    
    public CharLine(final int numLines){
	this('═', numLines);
    }
    
    public CharLine(final char charToRepeat){
	this(charToRepeat, 1);
    }
	
    public CharLine(final char charToRepeat, final int numLines){
	this.numLines = numLines;
	line = new StringBuilder(" ");
	for(int n=0; n<UI_SIZE; n++)
	    line.append(charToRepeat);
    }
	
    @Override
    public void print(){
	for(int i=0; i<numLines; i++)
	    System.out.println(line);
    }
}
