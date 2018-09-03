package br.unip.model.sorters;

public class QuickSorter implements Sorter{
    
    private Comparable[] items;
    private boolean isReverse;
    
    @Override
    public void sort(Comparable[] items, boolean isReverse) {
	this.isReverse = isReverse;
	this.items = items;
	this.sort(0, items.length-1);
    }
    
    /**
     * Controla processo de particionamento do atributo 'items' recursivamente,
     * para que este seja ordenado.
     * @param start
     * @param end 
     */
    private void sort(int start, int end){
	if(start < end){
	    int pivot = partition(start, end);
	    this.sort(start, pivot-1);
	    this.sort(pivot+1, end);
	}
    }
    
    /**
     * Organiza as partes do atributo 'items' de acordo com variável 'isReverse' 
     * ambos definidos pelo construtor.
     * @param start
     * @param end
     * @return newPivot
     */
    private int partition(int start, int end){
	Comparable pivot = items[start];
	int lb = start+1;
	int ub = end;
	while(lb <= ub){
	    if((pivot.compareTo(items[lb])*(isReverse?-1:1)) > 0)lb++;
	    else if((pivot.compareTo(items[ub])*(isReverse?-1:1)) <= 0) ub--;
	    else{
		Comparable temp = items[lb];
		items[lb] = items[ub];
		items[ub] = temp;
		lb++;
		ub--;
	    }
	}
	items[start] = items[ub];
	items[ub] = pivot;
	return ub;
    }

    @Override
    public String getMethodName() {
	return "Método Quick";
    }

    @Override
    public String getMethodBrief() {
	return "O Quick Sort se baseia na ideia de escolher um elemento que se "
		+ "denomina \"pivô\", ele será considerado uma referência de or"
		+ "denação, do qual os elementos que possuem um valor menor que"
		+ " o pivô serão postos antes dele, e os valores que são maiore"
		+ "s que a referência após ele.";
    }
    
}
