package view.output.structures;

import view.output.components.ClosedText;
import view.output.components.DashLine;
import java.io.IOException;
import view.output.Alignment;
import view.output.components.CharLine;
import view.output.CmdOutput;

public class TopBox implements CmdOutput{   
    private final String title;
    private final int bottomLines;
    
    public TopBox(String title){
        this(title, 1);
    }
    
    public TopBox(String title, int bottomLines){
	this.title = title;
	this.bottomLines = bottomLines;
    }

    public TopBox() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
	new DashLine().print();
	new ClosedText(title, Alignment.CENTER).print();
	new DashLine(bottomLines).print();
    }
    
}
