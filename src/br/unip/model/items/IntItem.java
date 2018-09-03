package br.unip.model.items;

import static br.unip.model.Configs.INT_MAXVALUE;

public class IntItem implements Item<IntItem>{
    private static final long serialVersionUID = 1L;
    
    private int value;
  
    public void setValue(int value) { this.value = value; }
    
    public int getValue() { return value; }  
    
    @Override
    public int compareTo(IntItem item) {
	return Integer.compare(this.value, item.value);
    }

    @Override
    public void generateRandom() {
	value = (int) (Math.random() * INT_MAXVALUE);
    }
    
    @Override
    public String toString() {
	return Integer.toString(value);
    } 
    
}
