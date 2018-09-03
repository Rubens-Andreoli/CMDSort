package view.output.structures;

import java.util.LinkedList;
import java.util.Map;

public class ComplexMenu extends Menu{
    
    public ComplexMenu(Map<String, String[]> mapItems){
	LinkedList<String> items = new LinkedList<String>();
	
	int i = 0;
	for(Map.Entry<String, String[]> entry : mapItems.entrySet()){
	    if(entry.getValue() == null){
		items.add(String.format("%2d - %s", ++i, entry.getKey().toUpperCase()));
	    }else{
		items.add(String.format("   - %s", entry.getKey().toUpperCase()));
		for(String subItem : entry.getValue()){
		    items.add(String.format("        %2d - %s", ++i, subItem));
		}
	    }
	}
	
	super.setItems(items.toArray(new String[items.size()]));
	super.setNumItems(i);
    }
    
}
