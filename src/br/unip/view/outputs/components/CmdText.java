package br.unip.view.outputs.components;

import br.unip.view.outputs.Alignment;
import br.unip.view.outputs.CmdOutput;

public abstract class CmdText implements CmdOutput {
    
    protected final StringBuilder output;
    private final String text;
    private final int maxLineChars;
    protected final Alignment align;
  
    public CmdText(final String text){
        this(text, Alignment.LEFT, UI_SIZE);
    }
    
    public CmdText(final String text, final Alignment align){
	this(text, align, UI_SIZE);
    }

    public CmdText(final String text, final Alignment align, final int maxLineChars){
        output = new StringBuilder("");
	this.text = text;
	this.align = align;
        this.maxLineChars = maxLineChars;
	startBuild();
    }
    
    private void startBuild(){
	if(text.length() > UI_SIZE) splitBuild();
	else{ 
	    output.append(" ");
	    buildLine(text);
	}
    }
    
    protected void splitBuild(){   
        for(int start=0, end=(maxLineChars); start<text.length(); start+=(end-start), end+=(maxLineChars)){
            output.append(" ");
	    if(end >= text.length()){
                buildLine(String.format(" %s", text.substring(start)));
            }else{
		while(end>start && text.charAt(end) != ' ') end--;
                buildLine(String.format(" %s", text.substring(start, end)));
                output.append("\n");
                end++;
            }
        }
    }
    
    protected abstract void buildLine(final String text); 
    
}
