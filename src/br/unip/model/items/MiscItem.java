package br.unip.model.items;

import static br.unip.model.Configs.MISC_MAX_CH;
import static br.unip.model.Configs.MISC_START_CH;
import static br.unip.model.Configs.MISC_MAX_VALUE;

public class MiscItem implements Item<MiscItem>{
    private static final long serialVersionUID = 1L;
    
    private char ch;
    private int value;

    public void setItem(char ch, int value){
	this.ch = Character.toUpperCase(ch);
	this.value = value;
    }
    
    public char getChar(){ return ch; }
    public int getValue(){ return value; }
    
    @Override
    public int compareTo(MiscItem item) {
	if(this.ch == item.ch){
	    if(this.value == item.value)
		return 0;
	    if(this.value > item.value)
		return 1;
	    return -1;
	}else if(this.ch > item.ch){
	    return 1;
	}else{
	    return -1;
	}
    }

    @Override
    public void generateRandom() {
	value = (int) (Math.random() * MISC_MAX_VALUE);
	ch = (char) (MISC_START_CH + ((int) (Math.random() * MISC_MAX_CH)));
    }

    @Override
    public String toString() {
	return ch+Integer.toString(value);
    }
    
}
