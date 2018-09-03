package br.unip.view.output.components;

import br.unip.view.output.Alignment;
import br.unip.view.output.CmdOutput;

public abstract class CmdText implements CmdOutput {
    
    protected StringBuilder output;
    private final String text;
    private final int maxLineChars;
    protected final Alignment align;
  
    public CmdText(String text){
        this(text, Alignment.LEFT, UI_SIZE);
    }
    
    public CmdText(String text, Alignment align){
	this(text, align, UI_SIZE);
    }

    public CmdText(String text, Alignment align, int maxLineChars){
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
    
    protected abstract void buildLine(String text); 
    
}
