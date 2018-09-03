package model.items;

public class MiscItem implements Item<MiscItem>{
    private static final long serialVersionUID = 1L;
    
    private char ch;
    private int value;
    private static final int MAX_VALUE = 1000;
    private static final char START_CH = 'A';
    private static final int MAX_CH = 26;	    /*Valor de 'ch' máximo com início em 'START_CH'*/

    public void setItem(char ch, int value){
	this.ch = Character.toUpperCase(ch);
	this.value = value;
    }
    
    public char getChar(){
	return ch;
    }
    
    public int getValue(){
	return value;
    }
    
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
	value = (int) (Math.random() * MAX_VALUE);
	ch = (char) (START_CH + ((int) (Math.random() * MAX_CH)));
    }

    @Override
    public String toString() {
	return ch+Integer.toString(value);
    }
    
}
