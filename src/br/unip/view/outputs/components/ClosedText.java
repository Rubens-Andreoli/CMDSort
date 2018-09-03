package br.unip.view.outputs.components;

import br.unip.view.outputs.Alignment;

public final class ClosedText extends CmdText{
    
    private static final char SIDE_CHAR = '║';
    
    public ClosedText(final String text){
	this(text, Alignment.LEFT);
    }
    
    public ClosedText(final String text, final Alignment align){
	super(text, align, UI_SIZE-4);
    }
       
    @Override
    protected void buildLine(final String text){
        int textSize = text.length(), spaces = UI_SIZE-textSize-2;
	switch(align){
	    case LEFT:
		output.append(SIDE_CHAR)
		    .append(text)
		    .append(String.format("%"+spaces+"c", ' '))
		    .append(SIDE_CHAR);
		break;
	    case RIGHT:
		output.append(SIDE_CHAR)
		    .append(String.format("%"+spaces+"c", ' '))
		    .append(text)
		    .append(SIDE_CHAR);
		break;
	    case CENTER:
		int isOdd = 0;
		if(spaces%2 != 0){
		    spaces--;
		    isOdd = 1;
		}
		spaces /= 2;
		output.append(SIDE_CHAR)
		    .append(String.format("%"+spaces+"c", ' '))
		    .append(text)
		    .append(String.format("%"+(spaces+isOdd)+"c", ' '))
		    .append(SIDE_CHAR);
		break;
            default:
                throw new AssertionError(align.name());
	}
    }

    @Override
    public void print(){
	System.out.println(output);
    }
}
