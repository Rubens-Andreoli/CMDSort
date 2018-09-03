package br.unip.view.outputs;

import br.unip.view.Alignment;
import static br.unip.view.Configs.WINDOW_SIZE;
import static br.unip.view.Configs.SIDE_CHAR;

public final class BoxedText extends CmdText{
    
    private char sideChar = SIDE_CHAR;

    public BoxedText(final String text){
	super(text, 5);
    }
    
    public BoxedText(final String text, final Alignment aln){
	super(text, 5, aln);
    }

    public void setSideChar(char sideChar) { this.sideChar = sideChar; }
    
    @Override
    protected void formatLine(String line) {
	int lineSize = line.length(), spaces = WINDOW_SIZE-lineSize-3;
	switch(aln){
	    case LEFT:
		super.getLines().add(String.format(" %c %s%"+spaces+"c%c", sideChar, line, ' ', sideChar));
		break;
	    case RIGHT:
		super.getLines().add(String.format(" %c%"+spaces+"c%s %c", sideChar, ' ', line, sideChar));
		break;
	    case CENTER:
		super.getLines().add(String.format(" %c%"+(spaces/2)+"c%s %"+(spaces-(spaces/2)+1)+"c", 
			sideChar, ' ', line, sideChar));
		break;
	}
    }
    
}
