package br.unip.model.sorters;

import static br.unip.model.Configs.INSERTION_BRIEF;
import static br.unip.model.Configs.INSERTION_NAME;

public final class InsertionSorter implements Sorter {

    @Override
    public void sort(Comparable[] items, boolean isReverse) {
	Comparable key;
	int i;
	for (int j=1; j < items.length; j++) {
	    key = items[j];
	    for (i = j-1; (i >= 0) && ((items[i].compareTo(key)*(isReverse?-1:1)) > 0); i--) {
		items[i+1] = items[i];
	    }
	    items[i+1] = key;
	}
    }

    @Override
    public String getMethodName() { return INSERTION_NAME; }

    @Override
    public String getMethodBrief() { return INSERTION_BRIEF; }

}
