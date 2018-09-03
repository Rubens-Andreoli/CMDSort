package br.unip.model.sorters;

public class QuickSorter implements Sorter{
    
    private boolean isReverse;
    
    @Override
    public void sort(Comparable[] items, boolean isReverse) {
	this.isReverse = isReverse;
	this.sort(items, 0, items.length-1);
    }
    
    private void sort(Comparable[] items, int start, int end){
	if(start < end){
	    int pivotIndex = split(items, start, end);
	    this.sort(items, start, pivotIndex - 1);
	    this.sort(items, pivotIndex + 1, end);
	}
    }
    
    private int split(Comparable[] items, int start, int end){
	Comparable pivot = items[start];
	int i = start+1;
	int e = end;
	while(i <= e){
	    int comparisonI = pivot.compareTo(items[i]);
	    int comparisonE = pivot.compareTo(items[e]);
	    if(isReverse){ 
		comparisonI*=(-1);
		comparisonE*=(-1);
	    }
	    
	    if(comparisonI > 0)i++;
	    else if(comparisonE <= 0) e--;
	    else{
		Comparable temp = items[i];
		items[i] = items[e];
		items[e] = temp;
		i++;
		e--;
	    }
	}
	items[start] = items[e];
	items[e] = pivot;
	return e;
    }

    @Override
    public String getMethodName() {
	return "Método Quick";
    }

    @Override
    public String getMethodBrief() {
	return "O Quick Sort se baseia na ideia de escolher um elemento que se denomina \"pivô\", ele será considerado uma referência de ordenação, do qual os elementos que possuem um valor menor que o pivô serão postos antes dele, e os valores que são maiores que a referência após ele.";
    }
    
}
