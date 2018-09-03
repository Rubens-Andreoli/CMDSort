package model.Items;

public class MiscItem implements Item<MiscItem>{
    private char ch;
    private int value;

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
    public int compareTo(MiscItem o) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void generateRandom() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
	return ch+Integer.toString(value);
    }
    
}
