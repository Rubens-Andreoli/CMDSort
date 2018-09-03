package view.output.components;

import view.output.Alignment;
import view.output.CmdOutput;

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
        output = new StringBuilder(" ");
	this.text = text;
	this.align = align;
        this.maxLineChars = maxLineChars;
	startBuild();
    }
    
    private void startBuild(){
	if(text.length() > UI_SIZE) splitBuild();
        else buildLine(text);
    }
    
    protected void splitBuild(){   
        for(int start=0, end=(maxLineChars); start<text.length(); start+=(end-start), end+=(maxLineChars)){
            if(end >= text.length()){
                buildLine(text.substring(start));
            }else{
                while(end>start && text.charAt(end) != ' ') end--;
                buildLine(text.substring(start, end));
                output.append("\n");
                end++;
            }
        }
    }
    
    protected abstract void buildLine(String text); 
    
}
