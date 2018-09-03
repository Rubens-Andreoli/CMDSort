package br.unip.model.items;

public class IntItem implements Item<IntItem>{
    private static final long serialVersionUID = 1L;
    
    private int value;
    private static final int MAX_VALUE = 26000;
  
    public void setValue(int value) {
	this.value = value;
    }
    
    public int getValue() {
	return value;
    }  
    
    @Override
    public int compareTo(IntItem item) {
	return Integer.compare(this.value, item.value);
    }

    @Override
    public void generateRandom() {
	value = (int) (Math.random() * MAX_VALUE);
    }
    
    @Override
    public String toString() {
	return Integer.toString(value);
    } 

}
