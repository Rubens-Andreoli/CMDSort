package br.unip.view.output.structures;

import br.unip.view.output.components.ClosedText;
import java.io.IOException;
import br.unip.view.output.Alignment;
import br.unip.view.output.components.CharLine;
import br.unip.view.output.CmdOutput;

public class TopBox implements CmdOutput{   
    private final String title;
    private final int bottomLines;
    
    public TopBox(String title){
        this(title, 1);
    }
    
    public TopBox(String title, int bottomLines){
	this.title = title.toUpperCase();
	this.bottomLines = bottomLines;
    }
    
    @Override
    public void print(){
	try {
	    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	} catch (IOException | InterruptedException ex) {
	    System.out.println();
	    new CharLine('*').print();
	    System.out.println();
	}
	new CharLine().print();
	new ClosedText(title, Alignment.CENTER).print();
	new CharLine(bottomLines).print();
    }
    
}
