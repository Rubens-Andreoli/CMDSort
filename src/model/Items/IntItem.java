package model.Items;

public class IntItem implements Item<IntItem>{
    
    private int value;
  
    public void setValue(int value) {
	this.value = value;
    }
    
    public int getValue() {
	return value;
    }  
    
    @Override
    public int compareTo(IntItem o) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void generateRandom() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
	return Integer.toString(value);
    } 
    
}
