package br.unip.model.sorters;

import static br.unip.model.Configs.BUBBLE_BRIEF;
import static br.unip.model.Configs.BUBBLE_NAME;

public final class BubbleSorter implements Sorter{

    @Override
    public void sort(Comparable[] items, boolean isReverse) {
	for(int i=0; i < items.length; i++){
	    for(int n=i+1; n < items.length; n++){
		if((items[i].compareTo(items[n])*(isReverse?-1:1)) > 0){
		    Comparable temp = items[i];
		    items[i] = items[n];
		    items[n] = temp;
		}
	    }
	}
    }

    @Override
    public String getMethodName() { return BUBBLE_NAME; }

    @Override
    public String getMethodBrief() { return BUBBLE_BRIEF; }
    
}
