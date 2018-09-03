package br.unip.view.outputs;

import static br.unip.view.Configs.LINE_CHAR;
import static br.unip.view.Configs.WINDOW_SIZE;
import java.util.Arrays;

public final class CharLine implements CmdOutput{
    
    private final char charToRepeat;
    private final int numLines;
    private StringBuilder output;
    
    public CharLine(){
	this(1);
    }
    
    public CharLine(final int numLines){
	this(LINE_CHAR , numLines);
    }
    
    public CharLine(final char charToRepeat){
	this(charToRepeat, 1);
    }
    
    public CharLine(final char charToRepeat, final int numLines){
	this.numLines = numLines;
	this.charToRepeat = charToRepeat;
    }
    
    @Override
    public void build(){
	output = new StringBuilder(" ");
	char[] line = new char[WINDOW_SIZE];
	Arrays.fill(line, charToRepeat);
	output.append(line);
    }

    @Override
    public void print(){
	for(int i=0; i<numLines; i++){
	    if(i < numLines-1) System.out.println(output);
	    else System.out.print(output);
	}
    }
    
    @Override
    public void println() {
	for(int i=0; i<numLines; i++){
	    System.out.println(output);
	}
    }
  
}
