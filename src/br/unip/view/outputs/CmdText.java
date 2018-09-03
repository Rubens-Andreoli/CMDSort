package br.unip.view.outputs;

import br.unip.view.Alignment;
import static br.unip.view.Configs.DFLT_ALIGNMENT;
import static br.unip.view.Configs.WINDOW_SIZE;
import java.util.LinkedList;
import java.util.List;

public abstract class CmdText implements CmdOutput{
    
    protected final String text;
    protected final Alignment aln;
    private String[] paragraphs;
    private int maxChars;
    private List<String> lines;

    public CmdText(final String text, final int splitMargin){
	this(text, splitMargin, DFLT_ALIGNMENT);
    }

    public CmdText(final String text, final int splitMargin, final Alignment aln){
	this.maxChars = WINDOW_SIZE-splitMargin;
	this.text = text;
	this.aln = aln;
    }
    
    @Override
    public void build(){
        this.paragraphs = text.split("\n"); 
        this.lines = new LinkedList<String>();
	for(String paragraph : paragraphs){
	    if(paragraph.length()>maxChars) splitFormat(paragraph);
	    else this.formatLine(paragraph);
	}
	int end = text.length();
	while(text.substring(0, end).endsWith("\n")){
	    this.formatLine("");
	    end--;
	}
    }
    
    protected void splitFormat(String paragraph){
	for(int start=0, end=maxChars; start<paragraph.length(); start+=((end-start)+1), end+=maxChars){
	    if(end >= paragraph.length()){
                this.formatLine(paragraph.substring(start));
            }else{
		while(end>start && paragraph.charAt(end) != ' ') end--;
		this.formatLine(paragraph.substring(start, end));
	    }   
        }
    }
    
    protected abstract void formatLine(String line);
    
    protected List<String> getLines(){ return lines; }
    
    @Override
    public void print(){
	for(int i=0; i<lines.size(); i++){
	    if(i < lines.size()-1) System.out.println(lines.get(i));
	    else System.out.print(lines.get(i));
	}
    }
    
    @Override
    public void println(){
	lines.stream().forEach((line) -> {
	    System.out.println(line);
	});
    }
}
