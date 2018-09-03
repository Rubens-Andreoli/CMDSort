package view.output.components;

public final class DashLine extends CharLine {
    private final static char DASH_CHAR = '═';
    
    public DashLine(){
        super(DASH_CHAR);
    }
    
    public DashLine(int numLines){
	super(DASH_CHAR, numLines);
    }
    
}
