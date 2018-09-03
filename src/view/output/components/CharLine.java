package view.output.components;

import view.output.CmdOutput;

public class CharLine implements CmdOutput {
    
    private StringBuilder line;
    private final int numLines;
	
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
