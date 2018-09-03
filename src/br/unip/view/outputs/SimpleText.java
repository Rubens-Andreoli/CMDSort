package br.unip.view.outputs;

import static br.unip.view.Configs.WINDOW_SIZE;
import br.unip.view.Alignment;

public final class SimpleText extends CmdText{
    
    public SimpleText(final String text){
	super(text, 1);
    }
    
    public SimpleText(final String text, final Alignment aln){
	super(text, 1, aln);
    }
    
    @Override
    public void formatLine(String line) {
	int lineSize = line.length(), spaces = WINDOW_SIZE-lineSize-1;
	switch(aln){
	    case LEFT:
		super.getLines().add(String.format(" %s", line));
		break;
	    case RIGHT:
		super.getLines().add(String.format(" %"+spaces+"c%s", ' ', line));
		break;
	    case CENTER:
		super.getLines().add(String.format(" %"+(spaces/2)+"c%s%"+(spaces-(spaces/2))+"c", 
			' ', line, ' '));
		break;
	}
    }

}
