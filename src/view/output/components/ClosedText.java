package view.output.components;

import view.output.Alignment;

public class ClosedText extends CmdText{
    private final static char SIDE_CHAR = '║';
    
    public ClosedText(String text){
	this(text, Alignment.LEFT);
    }
    
    public ClosedText(String text, Alignment align){
	super(text, align, UI_SIZE-4);
    }
       
    @Override
    protected final void buildLine(String text){
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
