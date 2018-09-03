package br.unip.view.output.components;

import br.unip.view.output.CmdOutput;

public class CharLine implements CmdOutput {
    private final static char DASH_CHAR = '═';
    
    private StringBuilder line;
    private final int numLines;
	
    public CharLine(){
	this(DASH_CHAR, 1);
    }
    
    public CharLine(int numLines){
	this(DASH_CHAR, numLines);
    }
    
    public CharLine(char charToRepeat){
	this(charToRepeat, 1);
    }
	
    public CharLine(char charToRepeat, int numLines){
	this.numLines = numLines;
	line = new StringBuilder(" ");
	for(int n=0; n<UI_SIZE; n++)
	    line.append(charToRepeat);
    }
	
    @Override
    public final void print(){
	for(int i=0; i<numLines; i++)
	    System.out.println(line);
    }
}
