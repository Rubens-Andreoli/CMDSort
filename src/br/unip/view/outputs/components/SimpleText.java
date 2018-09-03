package br.unip.view.outputs.components;

import br.unip.view.outputs.Alignment;

public final class SimpleText extends CmdText {
  
    public SimpleText(final String text){
        this(text, Alignment.LEFT);
    }

    public SimpleText(final String text, final Alignment align){
        super(text, align, UI_SIZE);
    }
    
    @Override
    protected void buildLine(final String text){
        int textSize = text.length(), spaces = UI_SIZE-textSize;
	switch(align){
	    case LEFT:
		output.append(text);
		break;
	    case RIGHT:
		output.append(String.format("%"+spaces+"c", ' '))
		    .append(text);
		break;
	    case CENTER:
		int isOdd = 0;
		if(spaces%2 != 0){ 
		    spaces--;
		    isOdd = 1;
		}
		spaces /= 2;
		output.append(String.format("%"+spaces+"c", ' '))
		    .append(text)
		    .append(String.format("%"+(spaces+isOdd)+"c", ' '));
		break;
            default:
                throw new AssertionError(align.name());
	}
    }  

    @Override
    public void print() {
	System.out.print(output);
    }
    
}
