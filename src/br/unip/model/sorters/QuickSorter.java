package br.unip.model.sorters;

import static br.unip.model.Configs.QUICK_BRIEF;
import static br.unip.model.Configs.QUICK_NAME;

public final class QuickSorter implements Sorter{
    
    private Comparable[] items;
    private boolean isReverse;
    
    @Override
    public void sort(Comparable[] items, boolean isReverse) {
	this.isReverse = isReverse;
	this.items = items;
	this.sort(0, items.length-1);
    }

    private void sort(int l, int r){
	int lb = l, ub = r;
	Comparable pivot = items[((l+r)/2)];
	do{
	    while(items[lb].compareTo(pivot)*(isReverse?-1:1) < 0) lb++;
	    while(items[ub].compareTo(pivot)*(isReverse?-1:1) > 0) ub--;
	    if(lb <= ub){
		Comparable temp = items[lb];
		items[lb] = items[ub];
		items[ub] = temp;
		lb++;
		ub--;
	    }
	}while(lb <= ub);
	if (l < ub) this.sort(l, ub);
	if (lb < r) this.sort(lb, r);
	
    }

    @Override
    public String getMethodName() { return QUICK_NAME; }

    @Override
    public String getMethodBrief() { return QUICK_BRIEF; }
    
}
